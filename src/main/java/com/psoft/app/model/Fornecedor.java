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
@Table (name="fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )  
    @Column (name ="id")
    @Getter private Integer id ;
        
    @Column (name ="nome")
    @Getter @Setter private String nome;
        
    @Column (name ="endereco") 
    @Getter @Setter private String endereco;

}
