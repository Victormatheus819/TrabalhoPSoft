package com.psoft.aplication.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table (name="item")
public class ItemVenda {

    @Id
    @Column (name="id")
    @Getter @Setter private int id;

    @Column (name ="id_produto") 
    @Getter @Setter private Produto produto;
    
    @Column (name ="quantidade") 
    @Getter @Setter private int quantidade;
}
