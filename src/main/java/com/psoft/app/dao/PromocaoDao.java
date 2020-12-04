package com.psoft.app.dao;

import com.psoft.app.model.Promocao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocaoDao extends JpaRepository<Promocao,Integer>  {

    @Query( value = "SELECT porcentagem_desconto FROM promocao WHERE data_inicial < now() AND data_final > now() AND id_produto = :id", nativeQuery = true)
	Double getToProduto(@Param("id") Integer id);
    
}