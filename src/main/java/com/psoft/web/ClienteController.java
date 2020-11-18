package com.psoft.web;

import com.psoft.aplication.model.Cliente;
import com.psoft.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ClienteController {
    @Autowired
    private ClienteService service;

    @RequestMapping (value="/",method=RequestMethod.GET)
    public String index (){
            return "index";
    }

    @RequestMapping(value="/", method = RequestMethod.POST )
    public String form(Cliente cliente){
       service.addClient(cliente);
        return "redirect:index";
    }

}
