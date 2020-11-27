package com.psoft.aplication.dao;

import com.psoft.aplication.model.Venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaDao extends JpaRepository<Venda,Integer>  {
    
}