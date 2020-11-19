package com.psoft.aplication.dao;

import com.psoft.aplication.model.ProdutoFornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoFornecedorDao extends JpaRepository<ProdutoFornecedor,Integer>  {
    
}

