package com.psoft.app.service;

import java.util.Date;

import com.psoft.app.dao.NotaFiscalDao;
import com.psoft.app.model.NotaFiscal;
import com.psoft.app.model.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaFiscalService {

    // gerar nota fiscal da venda e salvar dados no banco
	public NotaFiscal gerarNotaFiscal(Venda vendaAtual) {

        System.out.println("/nACESSANDO API PARA GERAR NOTA FISCAL!!!/n");

        NotaFiscal nota = new NotaFiscal();
        nota.setVenda(vendaAtual);
        nota.setData(new Date());
        nota.setCodigo(this.gerarCodigo(vendaAtual));
        notaFiscalDao.save(nota);

        System.out.println("/nNOTA FISCAL FOI GERADA!!!/n");
        return nota;
    }

    private String gerarCodigo(Venda venda) {
		String codigo = "000";
		codigo += venda.getVendedor().getCodigo();
		codigo += venda.getCliente().getId();
		codigo += venda.getId();

		return codigo;
	}
    
    @Autowired
    private NotaFiscalDao notaFiscalDao;


}
