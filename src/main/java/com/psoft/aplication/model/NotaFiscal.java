package com.psoft.aplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="nota_fiscal")
public class NotaFiscal {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) 
    @Column (name = "id")
    @Getter private Integer id;

    @Column (name = "codigo") 
    @Getter @Setter private String codigo;

}
