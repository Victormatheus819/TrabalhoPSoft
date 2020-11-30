package com.psoft.app.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SegurancaInterceptor extends HandlerInterceptorAdapter {

    // intercepta requisições e verifica se o sistema foi ativo e possui usuário logado
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("\nINTERCEPTOR WEB!!!");		

        System.out.println(request.getRequestURI());		

        Boolean naoValidar = (Boolean) request.getSession().getAttribute("naoValidar");
        if(naoValidar != null || request.getRequestURI().equals("/")){
            request.getSession().removeAttribute("naoValidar");
            return true;
        }

        Boolean sistemaAtivo = (Boolean) request.getSession().getAttribute("sistemaAtivo");
        if(sistemaAtivo == null && !request.getRequestURI().equals("/ativarSistema") ){
            response.sendRedirect(request.getContextPath() + "/");
            return false;
        }

        Integer idUsuarioLogado = (Integer) request.getSession().getAttribute("idUsuario");
        if(idUsuarioLogado == null && !request.getRequestURI().equals("/login") && !request.getRequestURI().equals("/ativarSistema")){
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        return true;
    }
    
}
