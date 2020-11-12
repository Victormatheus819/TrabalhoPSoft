package com.psoft.aplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name="tipo_pagamento")
public class TipoPagamento {
    
    @Id
    @Column( name = "id")
    @Getter @Setter private int id;

    @Column( name = "metodo" )
    @Getter @Setter private String metodo;
}