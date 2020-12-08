package com.psoft.app.dao;

import com.psoft.app.model.Gerente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GerenteDao extends JpaRepository<Gerente,Integer>  {
    
    // query para recuperar gerente por nome, senha e ativo
    Gerente findByCodigoAndSenhaAndAtivo(String codigo, String senha, boolean ativo);

    // query para recuperar gerente por nome, senha e ativo
    Gerente findByNomeAndSenhaAndAtivo(String nome, String senha, boolean ativo);

    // query para recuperar qualquer 1 gerente pela senha
    @Query(value = "SELECT id FROM gerente WHERE senha=:senha LIMIT 1", nativeQuery =true)
	Integer findOneBySenha(@Param("senha") String senha);

}