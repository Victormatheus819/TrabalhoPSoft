package com.psoft.app.dao;

import com.psoft.app.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDao extends JpaRepository<Produto,Integer>  {
    
    public Produto findByCodigoBarras(String codigoBarras);
    
}

