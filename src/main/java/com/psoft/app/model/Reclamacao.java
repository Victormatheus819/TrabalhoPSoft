package com.psoft.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="reclamacao")
public class Reclamacao {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) 
    @Column (name ="id") 
    @Getter private Integer id;
    
    @ManyToOne
    @JoinColumn (name ="id_cliente") 
    @Getter @Setter private Cliente cliente;
    
    @Column (name ="comentario") 
    @Getter @Setter private String comentario;
    
    @Column (name ="data") 
    @Getter @Setter private Date data;

}
