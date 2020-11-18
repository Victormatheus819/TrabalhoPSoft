package com.psoft.aplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VendaController {
	
    @RequestMapping ("/venda")
    public String venda (){
        return "venda";
    }
}
