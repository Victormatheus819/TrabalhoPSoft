package com.psoft.aplication.dao;

import com.psoft.aplication.model.Fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoDao extends JpaRepository<Fornecedor,Integer>  {
    
}