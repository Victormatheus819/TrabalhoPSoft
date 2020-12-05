package com.psoft.app.service;

import com.psoft.app.model.Item;
import com.psoft.app.model.Venda;

import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    
    // calcualr valor total a ser pago de uma venda
    public Double calcularValorTotal(Venda venda) {
        double valor = 0.0;
		for(Item item : venda.getItens()){
            valor = valor + (item.getProduto().getPreco() * item.getQuantidade());
        }
        return valor;
    }

	public Venda addTipoPagamento(Venda venda) {
        // implementar recuperação tipo pagamento
        //setar tipo pagamento em venda
		return venda;
	}

}
