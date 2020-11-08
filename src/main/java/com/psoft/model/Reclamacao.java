package com.psoft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

public class Reclamacao {
    @JoinColumn (name ="") @Getter @Setter private Cliente cliente ;
    
    @Column (name ="") @Getter @Setter private String descricao ;
    
    @Column (name ="") @Getter @Setter private Date data ;

}
