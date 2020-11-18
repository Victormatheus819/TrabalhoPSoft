package com.psoft.aplication.service;

import java.util.List;
import java.util.Optional;

import com.psoft.aplication.model.Cliente;
import com.psoft.aplication.dao.ClienteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
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
