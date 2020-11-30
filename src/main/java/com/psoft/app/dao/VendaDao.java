package com.psoft.app.dao;

import com.psoft.app.model.Venda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaDao extends JpaRepository<Venda,Integer>  {
    
}