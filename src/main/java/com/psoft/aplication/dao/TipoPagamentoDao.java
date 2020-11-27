package com.psoft.aplication.dao;

import com.psoft.aplication.model.TipoPagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagamentoDao extends JpaRepository<TipoPagamento,Integer>  {
    
}
