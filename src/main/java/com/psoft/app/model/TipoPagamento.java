package com.psoft.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name="tipo_pagamento")
public class TipoPagamento {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) 
    @Column( name = "id")
    @Getter @Setter private Integer id;

    @Column( name = "metodo" )
    @Getter @Setter private String metodo;
}