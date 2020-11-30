package com.psoft.app.dao;

import com.psoft.app.model.Gerente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteDao extends JpaRepository<Gerente,Integer>  {
    
    Gerente findByCodigoAndSenhaAndAtivo(String codigo, String senha, boolean ativo);

    Gerente findByNomeAndSenhaAndAtivo(String nome, String senha, boolean ativo);

}