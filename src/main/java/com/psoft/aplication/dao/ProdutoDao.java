package com.psoft.aplication.dao;

import com.psoft.aplication.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDao extends JpaRepository<Produto,Integer>  {
    
}

