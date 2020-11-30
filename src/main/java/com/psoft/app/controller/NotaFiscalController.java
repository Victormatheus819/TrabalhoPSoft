package com.psoft.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotaFiscalController {
    @RequestMapping ("/nota-fiscal")
    public String index (){
        return "notaFiscal";
    }
}
