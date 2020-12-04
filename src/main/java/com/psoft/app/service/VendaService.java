package com.psoft.app.service;

import java.util.ArrayList;
import java.util.List;

import com.psoft.app.ObservableLoja;
import com.psoft.app.ObserverLoja;
import com.psoft.app.dao.ProdutoDao;
import com.psoft.app.dao.VendaDao;
import com.psoft.app.model.Cliente;
import com.psoft.app.model.Item;
import com.psoft.app.model.Produto;
import com.psoft.app.model.TipoPagamento;
import com.psoft.app.model.Venda;
import com.psoft.app.model.Vendedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService implements ObservableLoja {

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

    private List<ObserverLoja> observers = new ArrayList();
    @Autowired
    private ProdutoDao produtoDao;
    @Autowired
    private VendaDao vendaDao;
    @Autowired
    private ProdutoService produtoService;
    
    public void salvarVenda(Venda venda){
        Cliente cli= new Cliente();
        Vendedor vend =new Vendedor();
        TipoPagamento tp = new TipoPagamento();
        cli.setId(1);
        vend.setId(1);
        tp.setId(1);
        venda.setVendedor(vend);
        venda.setCliente(cli);
        venda.setTipoPagamento(tp);
        venda.getItens().forEach((item) -> item.setVenda(venda));
        vendaDao.save(venda);
        this.registerObserver(produtoService);
        for(Item item : venda.getItens()){
            this.notifyObservers(item);
        } 

    }
     @Override
       public void registerObserver(ObserverLoja observer) {
            observers.add(observer);
       }
 
       @Override
       public void removeObserver(ObserverLoja observer) {
            observers.remove(observer);
       }
 
       @Override
       public void notifyObservers(Item item) {
            for (ObserverLoja ob : observers) {
            System.out.println("Notificando observers!");
              ob.update(item);
            }
       }


    
}
