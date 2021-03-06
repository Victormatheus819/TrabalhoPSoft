package com.psoft.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.psoft.app.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    // método para iniciar interface index ao acessar o sistema
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    // validação de ativação do sistema pela interface index
    @PostMapping("/ativarSistema")
    public ModelAndView ativarSistema(String codigo, String senha, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        if (this.loginService.sistemaAtivo(codigo, senha)) {
            session.removeAttribute("erroAtivaSistema");
            session.setAttribute("sistemaAtivo", true);
            mv.setViewName("login");
        } else {
            session.setAttribute("erroAtivaSistema", "Gerente não encontrado! Tente novamente");
            mv.setViewName("index");
        }
        return mv;
    }

    // validação de autenticação de usuário pela interface login
    @PostMapping("/login")
    public ModelAndView autenticar(HttpServletRequest request, HttpServletResponse response, String tipoUsuario,
            String codigo, String senha, HttpSession session) throws IOException {
        ModelAndView mv = new ModelAndView();
        
        Integer idUsuario = this.loginService.getIdUsuarioAutenticacao(tipoUsuario, codigo, senha);
        if(idUsuario == null){
            session.setAttribute("erroLogin", "Usuário não encontrado! Tente novamente");
            mv.setViewName("login");
        }else{
            session.removeAttribute("erroLogin");
            session.setAttribute("tipoUsuario", tipoUsuario);
            session.setAttribute("idUsuario", idUsuario);
            response.sendRedirect(request.getContextPath() + "/venda");
        }
        return mv;
    }

    // ativar sistema
    @GetMapping("/ativarSistema")
    public ModelAndView redirecionarIndex( HttpSession session ){
        ModelAndView mv = new ModelAndView();
        session.setAttribute("naoValidar", true);
        mv.setViewName("index");
        return mv;
    }

    // realizar autenticação
    @GetMapping("/login")
    public ModelAndView redirecionarLogin( HttpSession session ){
        ModelAndView mv = new ModelAndView();
        session.setAttribute("naoValidar", true);
        mv.setViewName("login");
        return mv;
    }

    @Autowired
    private LoginService loginService;

}
