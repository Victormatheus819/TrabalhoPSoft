package com.psoft.aplication.dao;

import com.psoft.aplication.model.Troca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrocaDao extends JpaRepository<Troca,Integer>  {
    
}
