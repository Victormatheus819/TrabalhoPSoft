package com.psoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table (name= "")
public class Produto {
    @Id
    @Column (name ="") @Getter @Setter private String nome ;
    @Column (name ="") @Getter @Setter private String codigo_identificacao;
    @Column (name ="") @Getter @Setter private  String codigo_barras  ;
    @Column (name ="") @Getter @Setter private float preco;
    @Column (name ="") @Getter @Setter private int quantidade;
    @JoinColumn (name="") @Getter @Setter private Fornecedor fornecedor;
   
}
