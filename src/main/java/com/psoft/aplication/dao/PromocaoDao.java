package com.psoft.aplication.dao;


import com.psoft.aplication.model.Promocao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoDao extends JpaRepository<Promocao,Integer>  {
    
}