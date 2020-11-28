package com.psoft.aplication.controller;

import javax.servlet.http.HttpSession;

import com.psoft.aplication.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    
    @RequestMapping ("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @PostMapping("/ativarSistema")
    public ModelAndView ativarSistema(String codigo, String senha, HttpSession session){
        ModelAndView mv = new ModelAndView();
        if(this.loginService.sistemaAtivo(codigo, senha)){
            session.removeAttribute("erroAtivaSistema");
            session.setAttribute("sistemaAtivo", true);
            mv.setViewName("login");
        }else{
            session.setAttribute("erroAtivaSistema", "Gerente não encontrado! Tente novamente");
            mv.setViewName("index");
        }
        return mv;
    }

    @Autowired
    private LoginService loginService;


}
