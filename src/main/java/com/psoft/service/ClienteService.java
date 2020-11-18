package com.psoft.service;

import java.util.List;
import java.util.Optional;

import com.psoft.aplication.model.Cliente;
import com.psoft.dao.ClienteDao;

import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService {
    @Autowired
    private ClienteDao dao;

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


}
