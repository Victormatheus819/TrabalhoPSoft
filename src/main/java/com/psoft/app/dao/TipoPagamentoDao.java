package com.psoft.app.dao;

import com.psoft.app.model.TipoPagamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPagamentoDao extends JpaRepository<TipoPagamento, Integer> {
}
