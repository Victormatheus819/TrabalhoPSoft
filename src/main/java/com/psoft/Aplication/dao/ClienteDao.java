package com.psoft.aplication.dao;

import com.psoft.aplication.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends JpaRepository<Cliente,Integer> {
    
}
