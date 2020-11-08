package com.psoft.model;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

public class Fornecedor {

    @Id
    @Column (name = "id") 
    @Getter private int id;

    @Column (name ="nome") 
    @Getter @Setter private String nome ;
    
    @Column (name ="endereco") 
    @Getter @Setter private String endereco ;

}
