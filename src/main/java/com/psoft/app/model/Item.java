package com.psoft.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="item")
public class Item {

    public Item(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = 1;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) 
    @Column (name = "id")
    @Getter private Integer id;

    @ManyToOne
    @JoinColumn (name = "id_produto") 
    @Getter @Setter private Produto produto;
    
    @Column (name = "quantidade") 
    @Getter @Setter private int quantidade;

    @ManyToOne
	@JoinColumn (name = "id_venda")
    @Getter @Setter private Venda venda;
    
    @Transient
    @Getter @Setter private Integer posicao;
}
