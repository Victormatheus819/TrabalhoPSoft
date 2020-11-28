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
@Table (name="vendedor")
public class Vendedor {

    @Id  
    @GeneratedValue( strategy = GenerationType.IDENTITY ) 
    @Column (name ="id") 
    @Getter private Integer id ;
    
    @Column (name ="nome")
    @Getter @Setter private String nome;
    
    @Column (name ="senha") 
    @Getter @Setter private String senha;

    @Column (name ="codigo") 
    @Getter @Setter private String codigo;
    
    @Column (name ="ativo") 
    @Getter @Setter private boolean ativo;
}
