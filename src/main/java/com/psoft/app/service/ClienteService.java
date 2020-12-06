package com.psoft.app.service;

import java.util.List;
import java.util.Optional;

import com.psoft.app.model.Cliente;
import com.psoft.app.dao.ClienteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {
    
    @Autowired
    private ClienteDao dao;

    public Cliente getClienteByCpf(String cpf){
        Cliente cliente = this.dao.findByCpf(cpf);
        return cliente;
    }

    public List<Cliente> getAllClients() {
        return dao.findAll();
    }

    public Optional<Cliente> getClient(int id){
        return dao.findById(id);
    }

   public void addClient(Cliente cliente){
       dao.save(cliente);
   } 

   public void updateClient(int id,Cliente cliente){
       dao.save(cliente);
   }
    
   public void deleteClient(Integer id){
       dao.deleteById(id);
   }

    public void removerPontos(Cliente cliente) {
        Integer pontos = cliente.getPontos();
        if(pontos == null || pontos < 100){
            return;
        }

        pontos = pontos - 100 * (pontos/100);
        cliente.setPontos(pontos);
        this.dao.save(cliente);
        return;
    }

	public void addPontos(Cliente cliente, Integer pontosVenda) {
        cliente.setPontos(cliente.getPontos() + pontosVenda);
        this.dao.save(cliente);
	}


}
