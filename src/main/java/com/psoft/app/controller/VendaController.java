package com.psoft.app.controller;

import javax.servlet.http.HttpSession;

import com.psoft.app.model.Item;
import com.psoft.app.model.Produto;
import com.psoft.app.model.Venda;
import com.psoft.app.service.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VendaController {
    
    //mapeamento Get para interface venda
    @GetMapping ("/venda")
    public String venda (HttpSession session){
        session.setAttribute("venda", new Venda());
        return "venda";
    }

    //criar novo item e adicionara a variável de sessão
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

    @Autowired
    private VendaService vendaService;

    @PostMapping("/concluir")
    public void concluirVenda(HttpSession session){
        Venda venda = (Venda) session.getAttribute("venda");
        vendaService.salvarVenda(venda);
    }
}
