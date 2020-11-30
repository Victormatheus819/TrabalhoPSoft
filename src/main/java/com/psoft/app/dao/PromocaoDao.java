package com.psoft.app.dao;

import com.psoft.app.model.Promocao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoDao extends JpaRepository<Promocao,Integer>  {
    
}