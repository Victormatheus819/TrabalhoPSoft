package com.psoft.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "venda")
public class Venda {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) 
    @Column (name ="id") 
    @Getter @Setter private Integer id;

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

    @OneToMany( targetEntity = Item.class, fetch = FetchType.EAGER, mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter private List<Item> itens = new ArrayList<Item>();
    
    @OneToOne
	@JoinTable( name = "venda_nota", joinColumns = {@JoinColumn( name = "id_venda" )}, inverseJoinColumns = {@JoinColumn( name = "id_nota" )} )
    private NotaFiscal notaFiscal;
    
    //Criar a instancia de item
    public void criarNovoItem(Produto produto, int quantidade) {
        Item item = new Item(produto, quantidade);
        this.itens.add(item);
    }
}
