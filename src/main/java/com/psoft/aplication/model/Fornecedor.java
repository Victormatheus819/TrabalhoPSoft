package com.psoft.aplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table (name="fornecedor")
public class Fornecedor {

    @Id
    @Column (name ="id") 
    @Getter private int id;

    @Column (name ="nome") 
    @Getter @Setter private String nome ;
    
    @Column (name ="endereco") 
    @Getter @Setter private String endereco ;

}
