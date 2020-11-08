package com.psoft.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

public class ItemVenda {
    @Id
    @JoinColumn (name ="") @Getter @Setter private Produto produto ;
    
    @Column (name ="") @Getter @Setter private int quantidade ;
}
