package com.psoft.aplication.controller;

import com.psoft.aplication.dao.ClienteDao;
import com.psoft.aplication.model.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteController {
    @Autowired
    private ClienteDao dao;
    
    @RequestMapping(value = "/teste", method = RequestMethod.GET)
    public String form(){
        return "index";  
    }
    
    @RequestMapping(value = "/teste", method = RequestMethod.POST)
    public String form(Cliente cliente){

        dao.save(cliente);
        return "index";  
    } 
}
