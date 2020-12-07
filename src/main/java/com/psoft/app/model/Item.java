package com.psoft.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="item")
public class Item {

    public Item(){
        
    }

    public Item(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) 
    @Column (name = "id")
    @Getter @Setter private Integer id;

    @ManyToOne
    @JoinColumn (name = "id_produto") 
    @Getter @Setter private Produto produto;
    
    @Column (name = "quantidade") 
    @Getter @Setter private int quantidade;

    @ManyToOne(targetEntity = Venda.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_venda", nullable = false)
    @Getter @Setter private Venda venda;
}
