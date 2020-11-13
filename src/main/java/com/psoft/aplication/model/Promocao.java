package com.psoft.aplication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name= "promocao")
public class Promocao {
    
    @Id
    @Column (name = "id") 
    @Getter private int id;

    @ManyToOne
    @JoinColumn (name = "id_produto") 
    @Getter @Setter private Produto produto;

    @Column (name = "data_inicial") 
    @Getter @Setter private Date dataInicial;

    @Column (name = "data_final") 
    @Getter @Setter private Date dataFinal;
    
}
