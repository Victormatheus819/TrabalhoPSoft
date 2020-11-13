package com.psoft.aplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name= "produto")
public class Produto {

    @Id
    @Column (name = "id") 
    @Getter private int id;

    @Column (name ="nome") 
    @Getter @Setter private String nome ;

    @Column (name ="codigo_identificacao") 
    @Getter @Setter private Integer codigo_identificacao;

    @Column (name ="codigo_barras") 
    @Getter @Setter private  String codigo_barras ;

    @Column (name ="preco") 
    @Getter @Setter private Double preco;

    @Column (name ="quantidade_estoque") 
    @Getter @Setter private int quantidade;
   
}
