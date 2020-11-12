package com.psoft.aplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity 
@Table (name="vendedor")
public class Vendedor {
    @Id  
    @Column (name ="id") 
    @Getter @Setter private  int id ;
    
    @Column (name ="nome")
    @Getter @Setter private String nome;
    
    @Column (name ="senha") 
    @Getter @Setter private String senha;
    
    @Column (name ="ativo") 
    @Getter @Setter private boolean ativo;
}
