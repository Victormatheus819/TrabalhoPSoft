package com.psoft.aplication.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "venda")
public class Venda {
    
    @Id
    @Column (name ="id") 
    @Getter private Integer id;

    @Column (name ="data_final") 
    @Getter @Setter private Date data;
    
    @Column (name ="status") 
    @Getter @Setter private String status;
    
    @ManyToOne
    @JoinColumn (name ="id_cliente") 
    @Getter @Setter private Cliente cliente; 
    
    @ManyToOne
    @JoinColumn (name ="id_tipo_pagamento") 
    @Getter @Setter private TipoPagamento tipoPagamento;

    @ManyToOne
    @JoinColumn (name ="id_vendedor") 
    @Getter @Setter private Vendedor vendedor;

    @OneToMany
    @JoinColumn(name = "id_venda") //coluna id_venda está na tabela item
    @Getter @Setter private List<Item> itens;
    
    @OneToOne
	@JoinTable( name = "venda_nota", joinColumns = {@JoinColumn( name = "id_venda" )}, inverseJoinColumns = {@JoinColumn( name = "id_nota" )} )
    private NotaFiscal notaFiscal;
    
}
