package com.psoft.app.service;

import com.psoft.app.dao.GerenteDao;
import com.psoft.app.dao.VendedorDao;
import com.psoft.app.model.Gerente;
import com.psoft.app.model.Vendedor;

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

	public boolean isGerente(String senha) {
        Integer id = this.gerenteDao.findOneBySenha( senha);
            if(id != null){
                return true;
            }
		return false;
	}

}
