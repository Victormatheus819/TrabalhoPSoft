package com.psoft.app.dao;

import com.psoft.app.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends JpaRepository<Cliente,Integer> {

    // query para recuperar cliente por CPF
    Cliente findByCpf(String cpf);
}
