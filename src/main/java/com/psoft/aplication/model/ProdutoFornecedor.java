package com.psoft.aplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name= "produto_fornecedor")
public class ProdutoFornecedor {

    @Id
    @Column (name = "id") 
    @Getter private int id;

    @ManyToOne
    @JoinColumn(name = "id_produto") 
    @Getter @Setter private Produto produto;

    @ManyToOne
    @JoinColumn (name = "id_fornecedor") 
    @Getter @Setter private Fornecedor fornecedor;

    @Column (name = "valor") 
    @Getter @Setter private Double valor;
    
}