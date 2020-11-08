package com.psoft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table (name="reclamacao")
public class Reclamacao {
    @Id
    @Column (name ="id") @Getter private Integer id;
    
    @JoinColumn (name ="id_cliente") @Getter @Setter private Cliente cliente;
    
    @Column (name ="comentario") @Getter @Setter private String comentario;
    
    @Column (name ="data") @Getter @Setter private Date data;

}
