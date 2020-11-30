package com.psoft.app.dao;

import com.psoft.app.model.ProdutoFornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoFornecedorDao extends JpaRepository<ProdutoFornecedor,Integer>  {
    
}

