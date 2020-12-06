package com.psoft.app.service;

import java.util.List;

import com.psoft.app.dao.TipoPagamentoDao;
import com.psoft.app.model.Item;
import com.psoft.app.model.TipoPagamento;
import com.psoft.app.model.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private TipoPagamentoDao tp;
    
    // calcualr valor total a ser pago de uma venda
    public Double calcularValorTotal(Venda venda) {
        double valor = 0.0;
		for(Item item : venda.getItens()){
            valor = valor + (item.getProduto().getPreco() * item.getQuantidade());
        }
        return valor;
    }

	public Venda addTipoPagamento(Venda venda, Integer formaPagamento) {
        TipoPagamento tipoPagamento = tp.findById(formaPagamento).get();
        venda.setTipoPagamento(tipoPagamento);
		return venda;
	}

}
