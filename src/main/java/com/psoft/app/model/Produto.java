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
@Table (name= "produto")
public class Produto {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) 
    @Column (name = "id") 
    @Getter private Integer id;

    @Column (name ="nome") 
    @Getter @Setter private String nome ;

    @Column (name ="codigo_identificacao") 
    @Getter @Setter private String codigoIdentificacao;

    @Column (name ="codigo_barras") 
    @Getter @Setter private  String codigoBarras ;

    @Column (name ="preco") 
    @Getter @Setter private Double preco;

    @Column (name ="quantidade_estoque") 
    @Getter @Setter private int quantidade;
   
}
