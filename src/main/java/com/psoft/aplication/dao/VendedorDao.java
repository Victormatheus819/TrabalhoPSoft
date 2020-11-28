package com.psoft.aplication.dao;

import com.psoft.aplication.model.Vendedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorDao extends JpaRepository<Vendedor,Integer>  {

    Vendedor findByCodigoAndSenhaAndAtivo(String codigo, String senha, boolean ativo);

    Vendedor findByNomeAndSenhaAndAtivo(String nome, String senha, boolean ativo);
    
}
