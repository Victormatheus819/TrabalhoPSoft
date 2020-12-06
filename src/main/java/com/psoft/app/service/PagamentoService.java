package com.psoft.app.service;

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
        return Math.round(valor * 100.0)/100.0;
    }

	public Venda addTipoPagamento(Venda venda, Integer formaPagamento) {
        TipoPagamento tipoPagamento = tp.findById(formaPagamento).get();
        venda.setTipoPagamento(tipoPagamento);
		return venda;
    }

    // calcular valor com desconto de pontuação para pagemento
	public Double calcularDescontoComPontuacao(Double valorTotal, Integer pontos) {
        if(pontos == null || pontos == 0){
            return 0.0;
        }
        int porcentagemDesconto = (pontos/100) * 10;
        valorTotal = valorTotal - (valorTotal * (porcentagemDesconto/100.0));
        return Math.round(valorTotal * 100.0)/100.0;
	}

}
