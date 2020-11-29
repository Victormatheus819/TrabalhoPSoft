package com.psoft.aplication.service;

import com.psoft.aplication.dao.GerenteDao;
import com.psoft.aplication.dao.VendedorDao;
import com.psoft.aplication.model.Gerente;
import com.psoft.aplication.model.Vendedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private GerenteDao gerenteDao;

    @Autowired
    private VendedorDao vendedorDao;

    public Boolean sistemaAtivo(final String codigo, final String senha){
        if(this.gerenteDao.findByCodigoAndSenhaAndAtivo(codigo, senha, true) == null){
            return false;
        }
        return true;
    }

	public Integer getIdUsuarioAutenticacao(String tipoUsuario, String codigo, String senha) {
        if(contemNumero(codigo)){
            if(tipoUsuario.equals("vendedor")){
               Vendedor vendedor = this.vendedorDao.findByCodigoAndSenhaAndAtivo(codigo, senha, true);
                if(vendedor != null){
                    return vendedor.getId();
                }
            }else{
                Gerente gerente = this.gerenteDao.findByCodigoAndSenhaAndAtivo(codigo, senha, true);
                if(gerente != null){
                    return gerente.getId();
                }
            }
        }else{
            if(tipoUsuario.equals("vendedor")){
                Vendedor vendedor = this.vendedorDao.findByNomeAndSenhaAndAtivo(codigo, senha, true);
                if(vendedor != null){
                    return vendedor.getId();
                }
            }else{
                Gerente gerente = this.gerenteDao.findByNomeAndSenhaAndAtivo(codigo, senha, true);
                if(gerente != null){
                    return gerente.getId();
                }
            }
        }

		return null;
	}

    private boolean contemNumero(String texto){
        for ( int i = 0; i < texto.length(); i++ ){
            if ( Character.isDigit( texto.charAt(i)) ) {
                return true;
            }
        }
        return false;
    }

}
