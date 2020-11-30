package com.psoft.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagamentoController {
    @RequestMapping ("/pagamento")
    public String index (){
        return "pagamento";
    }
}
