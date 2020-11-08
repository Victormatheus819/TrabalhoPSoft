package com.psoft.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table (name="item")
public class ItemVenda {
    @Id
    @JoinColumn (name ="id_produto") @Getter private Produto produto;
    
    @Column (name ="quantidade") @Getter @Setter private int quantidade;
}
