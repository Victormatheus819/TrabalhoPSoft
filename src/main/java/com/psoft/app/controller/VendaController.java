package com.psoft.app.controller;

import javax.servlet.http.HttpSession;

import com.psoft.app.model.Item;
import com.psoft.app.model.Venda;
import com.psoft.app.service.VendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
    public Item criaItem(@PathVariable( value = "codigo" ) final String codigo, @PathVariable( value = "quantidade" ) final Integer quantidade, HttpSession session){
        Venda vendaAtual = (Venda) session.getAttribute("venda");
        vendaAtual = this.vendaService.criaItem(codigo, quantidade, vendaAtual);
        session.removeAttribute("venda");
        session.setAttribute("venda", vendaAtual);

        return vendaAtual.getItens().get(vendaAtual.getItens().size() - 1);
    }

    // remover item da variavel de sessão
    @GetMapping("/removerItem/{posicao}")
    @ResponseBody
    public Boolean removeItem(@PathVariable( value = "posicao" ) final Integer posicao, HttpSession session){
        Venda vendaAtual = (Venda) session.getAttribute("venda");
        vendaAtual = this.vendaService.removeItem(vendaAtual, posicao);
        session.removeAttribute("venda");
        session.setAttribute("venda", vendaAtual);
        return true;
    }

    // adiciona CPF do Cliente na sessão
    @PutMapping("/clienteVenda/{cpf}")
    @ResponseBody
    public void adicionaCpfCliente(@PathVariable( value = "cpf" ) final String cpf, HttpSession session){
        session.setAttribute("cpfCliente", cpf);
    }


    @Autowired
    private VendaService vendaService;
}
