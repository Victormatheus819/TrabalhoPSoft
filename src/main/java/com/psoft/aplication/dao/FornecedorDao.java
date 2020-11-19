package com.psoft.aplication.dao;

import com.psoft.aplication.model.Fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorDao extends JpaRepository<Fornecedor,Integer>  {
    
}
