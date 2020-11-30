package com.psoft.app.dao;

import com.psoft.app.model.Troca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrocaDao extends JpaRepository<Troca,Integer>  {
    
}
