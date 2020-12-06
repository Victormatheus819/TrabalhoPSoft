package com.psoft.app.service;

import java.util.Date;

import com.psoft.app.dao.NotaFiscalDao;
import com.psoft.app.model.NotaFiscal;
import com.psoft.app.model.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaFiscalService {
	@Autowired
	private NotaFiscalDao notaFiscalDao;

	private String gerarCodigo(Venda venda) {
		String codigo = "000";
		codigo += venda.getVendedor().getCodigo();
		codigo += venda.getCliente().getId();
		codigo += venda.getId();

		return codigo;
	}

	public NotaFiscal gerarNotaFiscal(Venda venda) {
		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setCodigo(gerarCodigo(venda));
		notaFiscal.setVenda(venda);
		notaFiscal.setData(new Date());

		return save(notaFiscal);
	}

	public NotaFiscal save(NotaFiscal notaFiscal) {
		return notaFiscalDao.save(notaFiscal);
	}
	
}
