package com.psoft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name= "troca")
public class Troca {
    
    @Id
    @Column (name = "id") 
    @Getter @Setter int id;

    @Column (name ="data") 
    @Getter @Setter private Date data ;
    
    @ManyToOne
    @JoinColumn (name= "id_venda") 
    @Getter @Setter Venda venda ;
}
