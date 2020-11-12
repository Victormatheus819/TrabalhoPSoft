package com.psoft.aplication.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name= "venda")
public class Venda {
    @Id
    @Column (name ="id") @Getter private Integer id;

    @Column (name ="data_final") @Getter @Setter private Date data;
    
    @Column (name ="status") @Getter @Setter private String status;
    
    @JoinColumn (name ="id_cliente") @Getter @Setter private Cliente cliente; 
    
    @JoinColumn (name ="id_tipo_pagamento") @Getter @Setter private Pagamento pagamento;

    @JoinColumn (name ="id_vendedor") @Getter @Setter private Vendedor vendedor;
    
    //@ManyToMany(cascade=CascadeType.ALL)
    //@JoinTable(
    //    name="item_venda",
    //    joinColumns={ @JoinColumn(name="id_venda", referencedColumnName="id") },
    //    inverseJoinColumns={ @JoinColumn(name="id_item") }
    //) @Getter @Setter private List<ItemVenda> itemVenda;

    @OneToMany
    @JoinColumn(name = "id_troca") @Getter @Setter private List<Troca> troca;
    
}
