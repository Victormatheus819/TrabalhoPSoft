package com.psoft.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.psoft.app.ObservableLoja;
import com.psoft.app.ObserverLoja;
import com.psoft.app.dao.ProdutoDao;
import com.psoft.app.dao.PromocaoDao;
import com.psoft.app.dao.VendaDao;
import com.psoft.app.dao.VendedorDao;
import com.psoft.app.model.Item;
import com.psoft.app.model.Produto;
import com.psoft.app.model.TipoPagamento;
import com.psoft.app.model.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService implements ObservableLoja {

    @Autowired
    private PromocaoDao promocaoDao;

    //criar item para venda
	public Venda criarItem(String codigo, Integer quantidade, Venda venda) {
        Produto produto = this.produtoDao.findByCodigoBarras(codigo);
        if(produto == null){
            return null;
        }
        Double porcentagemDesconto = this.promocaoDao.getToProduto(produto.getId());
        if(porcentagemDesconto != null){
            produto.setPreco( produto.getPreco() - (produto.getPreco() * (porcentagemDesconto/100)));
        }
        venda.criarNovoItem(produto, quantidade);
        return venda;
    }

     // remover item de venda
	public Venda removerItem(Venda vendaAtual, String codigoBarras) {
        for( int i = 0; i < vendaAtual.getItens().size(); i++){
            Item item = vendaAtual.getItens().get(i);
            if(item.getProduto().getCodigoBarras().equals(codigoBarras)){
                item.setQuantidade(item.getQuantidade() - 1);
            }
            if(item.getQuantidade() == 0){
                vendaAtual.getItens().remove(i);
            }
        }
        return vendaAtual;
    }

    // relacionar vendedor à venda
    public Venda adicionarVendedor(Venda venda, Integer idVendedor) {
        venda.setVendedor( this.vendedorDao.findById(idVendedor).get());
        return venda;
    }
    
    //calcular pontuação gerada pela venda
    public int calcularPontuacaoDaVenda(Venda venda){
        int pontos = 0 ;
        for(Item item : venda.getItens()){
           pontos = (int) (pontos + (item.getProduto().getPreco()*item.getQuantidade()));
        }
         pontos = (int) (pontos * 0.1);
         
        return pontos;
        
    }


    
    private List<ObserverLoja> observers = new ArrayList();
    
    @Autowired
    private ProdutoDao produtoDao;

    @Autowired
    private VendedorDao vendedorDao;
    
    @Autowired
    private VendaDao vendaDao;
    
    @Autowired
    private ProdutoService produtoService;
    
    public void salvarVenda(Venda venda){
        venda.getItens().forEach((item) -> item.setVenda(venda));
        venda.setData(new Date());
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
