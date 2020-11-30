package com.psoft.app.dao;

import com.psoft.app.model.Reclamacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamacaoDao extends JpaRepository<Reclamacao,Integer>  {
    
}

