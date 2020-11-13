package com.psoft.aplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="nota_fiscal")
public class NotaFiscal {
    
    @Id
    @Column (name = "id")
    @Getter private int id;

    @Column (name = "codigo") 
    @Getter @Setter private String codigo;

}
