package com.psoft.app.dao;

import com.psoft.app.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDao extends JpaRepository<Produto,Integer>  {
    
    public Produto findByCodigoBarras(String codigoBarras);

    @Modifying
    @Query( value = "UPDATE produto SET quantidade_estoque = :novaQuantidade WHERE id = :id", nativeQuery = true)
    public void updateEstoqueProduto(@Param("novaQuantidade") Integer novaQuantidade, @Param("id") Integer id);
    
}

