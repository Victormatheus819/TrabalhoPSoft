package com.psoft.app.service;

import java.util.List;

import com.psoft.app.dao.ProdutoDao;
import com.psoft.app.model.Item;
import com.psoft.app.model.Produto;
import com.psoft.app.model.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    //criar item 
	public Venda criaItem(String codigo, Integer quantidade, Venda venda) {
        Produto produto = this.produtoDao.findByCodigoBarras(codigo);
        if(produto == null){
            return null;
        }
        for(int i = 0; i < quantidade; i++){
            venda.criarNovoItem(produto, quantidade);
        }
        venda.setItens(this.setPosicaoDeItens(venda.getItens()));
        return venda;
    }

     // remover item
	public Venda removeItem(Venda vendaAtual, int posicao) {
        vendaAtual.getItens().remove(posicao);
        return vendaAtual;
    }
    
    // ajustar lista de item para interface
    private List<Item> setPosicaoDeItens(List<Item> itemList){
        int posicao = 0;
        for(Item item : itemList){
            item.setPosicao(posicao);
            posicao++;
        }
        return itemList;
    }
    
    @Autowired
    private ProdutoDao produtoDao;

   
    
}
