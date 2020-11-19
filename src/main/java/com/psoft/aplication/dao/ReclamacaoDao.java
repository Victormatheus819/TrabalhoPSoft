package com.psoft.aplication.dao;

import com.psoft.aplication.model.Reclamacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamacaoDao extends JpaRepository<Reclamacao,Integer>  {
    
}

