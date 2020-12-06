package com.psoft.app.service;

import com.psoft.app.dao.ClienteDao;
import com.psoft.app.model.Item;
import com.psoft.app.model.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    @Autowired
    ClienteDao clienteDao;
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

    // calcular valor com desconto de pontuação para pagemento
	public Double calcularDescontoComPontuacao(Double valorTotal, Integer pontos) {
        if(pontos == null || pontos == 0){
            return 0.0;
        }
        int porcentagemDesconto = (pontos/100) * 10;
        return valorTotal - (valorTotal * (porcentagemDesconto/100.0));
	}

}
