package com.psoft.app.service;

import java.util.Optional;

import com.psoft.app.model.Cliente;
import com.psoft.app.dao.ClienteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {
    
    // recuperar cliente pelo CPF
    public Cliente getClienteByCpf(String cpf){
        Cliente cliente = this.clienteDao.findByCpf(cpf);
        return cliente;
    }

    // recuperar Cliente pelo id
    public Optional<Cliente> getClient(int id){
        return this.clienteDao.findById(id);
    }

    // remover pontos de um cliente
    public void removerPontos(Cliente cliente) {
        Integer pontos = cliente.getPontos();
        if(pontos == null || pontos < 100){
            return;
        }

        pontos = pontos - 100 * (pontos/100);
        cliente.setPontos(pontos);
        this.clienteDao.save(cliente);
        return;
    }

    // adicionar pontos de um cliente
	public void addPontos(Cliente cliente, Integer pontosVenda) {
        cliente.setPontos(cliente.getPontos() + pontosVenda);
        this.clienteDao.save(cliente);
    }
    
    
    @Autowired
    private ClienteDao clienteDao;


}
