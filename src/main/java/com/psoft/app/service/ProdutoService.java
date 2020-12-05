package com.psoft.app.service;

import javax.transaction.Transactional;

import com.psoft.app.ObserverLoja;
import com.psoft.app.dao.ProdutoDao;
import com.psoft.app.model.Item;
import com.psoft.app.model.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService implements ObserverLoja  {
    @Autowired
    private ProdutoDao produtoDao;
    
    @Override
    @Transactional
    public void update(Item item) {
        Produto produto = item.getProduto();
        produtoDao.updateEstoqueProduto(produto.getQuantidade() - item.getQuantidade(), produto.getId());
    }

  

   
    
}
