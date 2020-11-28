package com.psoft.aplication.service;

import com.psoft.aplication.dao.GerenteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private GerenteDao gerenteDao;

    public Boolean sistemaAtivo(final String codigo, final String senha){
        if(this.gerenteDao.findByCodigoAndSenha(codigo, senha) == null){
            return false;
        }
        return true;
    }


}
