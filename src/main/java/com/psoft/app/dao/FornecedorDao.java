package com.psoft.app.dao;

import com.psoft.app.model.Fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorDao extends JpaRepository<Fornecedor,Integer>  {
    
}
