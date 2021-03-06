package com.psoft.app.controller;

import javax.servlet.http.HttpSession;

import com.psoft.app.model.Cliente;
import com.psoft.app.model.Produto;
import com.psoft.app.model.Venda;
import com.psoft.app.service.ClienteService;
import com.psoft.app.service.LoginService;
import com.psoft.app.service.NotaFiscalService;
import com.psoft.app.service.PagamentoService;
import com.psoft.app.service.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VendaController {
    
    // mapeamento Get para interface venda
    @GetMapping ("/venda")
    public String venda (HttpSession session){
        session.setAttribute("venda", new Venda());
        return "venda";
    }

    // criar novo item e adicionara a variável de sessão
    @GetMapping("/criaItem/{codigo}/{quantidade}")
    @ResponseBody
    public Produto criarItem(@PathVariable( value = "codigo" ) final String codigo, @PathVariable( value = "quantidade" ) final Integer quantidade, HttpSession session){
        Venda vendaAtual = (Venda) session.getAttribute("venda");
        vendaAtual = this.vendaService.criarItem(codigo, quantidade, vendaAtual);
        if(vendaAtual == null){
            return null;
        }
        session.removeAttribute("venda");
        session.setAttribute("venda", vendaAtual);

        return vendaAtual.getItens().get(vendaAtual.getItens().size() - 1).getProduto();
    }

    // remover item da variavel de sessão
    @GetMapping("/removerItem/{codigobarras}")
    @ResponseBody
    public Boolean removerItem(@PathVariable( value = "codigobarras" ) final String codigobarras, HttpSession session){
        Venda vendaAtual = (Venda) session.getAttribute("venda");
        vendaAtual = this.vendaService.removerItem(vendaAtual, codigobarras);
        session.removeAttribute("venda");
        session.setAttribute("venda", vendaAtual);
        return true;
    }

    // adiciona CPF do Cliente na sessão
    @GetMapping("/clienteVenda/{cpf}")
    @ResponseBody
    public boolean adicionaCpfCliente(@PathVariable( value = "cpf" ) final String cpf, HttpSession session){
        
        Cliente clienteAtual = this.clienteService.getClienteByCpf(cpf);
        if(clienteAtual == null){
            return false;
        }

        Venda vendaAtual = (Venda) session.getAttribute("venda");
        vendaAtual.setCliente(clienteAtual);

        session.removeAttribute("venda");
        session.setAttribute("venda", vendaAtual);
        return true;
    }

    // exclui a venda atual e retorna para a interface de venda
    @GetMapping("/removerVenda")
    @ResponseBody
    public Boolean removerVenda( @RequestParam( value = "senhaGerente") String senha, HttpSession session) {
        if(!this.loginService.isGerente(senha)){
            return false;
        }
        session.removeAttribute("cpfCliente");
        session.removeAttribute("venda");
        return true;
    }

    // calcular informações de pagamento da venda
    @RequestMapping ("/pagamentoVenda")
    public ModelAndView prepararPagamentoDaVenda(HttpSession session){
        ModelAndView mv = new ModelAndView("pagamento");
        Venda vendaAtual = (Venda) session.getAttribute("venda");

        Double valorTotal = this.pagamentoService.calcularValorTotal(vendaAtual);
        mv.addObject("valorTotal", valorTotal);

        if(vendaAtual.getCliente().getPreferencial()){
            mv.addObject("pontosDaVenda", this.vendaService.calcularPontuacaoDaVenda(vendaAtual));

            mv.addObject("valorComDesconto", this.pagamentoService.calcularDescontoComPontuacao(valorTotal, vendaAtual.getCliente().getPontos()));
        }

        return mv;
    }

    //salvar informações de venda que acaba de ser concluída
    @PostMapping("/confirmarPagamentoVenda")
    public ModelAndView concluirVenda(HttpSession session, @RequestParam(value ="formaPagamento") Integer formaPagamento, @RequestParam(value ="valorTotal") String valorTotal, 
    @RequestParam(value ="desconto", required = false) String desconto, @RequestParam(value ="valorDesconto") String valorDesconto, @RequestParam(value ="pontos") Integer pontos){
        ModelAndView mv = new ModelAndView("notaFiscal");
        Venda vendaAtual = this.pagamentoService.addTipoPagamento((Venda) session.getAttribute("venda"), formaPagamento);

        vendaAtual = this.vendaService.adicionarVendedor(vendaAtual, (Integer) session.getAttribute("idUsuario")); 
        
        this.vendaService.salvarVenda(vendaAtual);
        vendaAtual.setNotaFiscal(notaFiscalService.gerarNotaFiscal(vendaAtual));

        session.removeAttribute("venda");
        mv.addObject("venda", vendaAtual);

        if(vendaAtual.getCliente().getPreferencial()){
            this.clienteService.addPontos(vendaAtual.getCliente(), pontos);
        }

        if(desconto != null){
            mv.addObject("valorTotal", valorDesconto);
            this.clienteService.removerPontos(vendaAtual.getCliente());
        }else{
            mv.addObject("valorTotal", valorTotal);

        }
        
        return mv;
    }
 

    @Autowired
    private VendaService vendaService;

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private NotaFiscalService notaFiscalService;

    @Autowired
    private LoginService loginService;
    
}
