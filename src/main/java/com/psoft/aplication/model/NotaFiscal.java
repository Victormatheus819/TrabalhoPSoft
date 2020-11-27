package com.psoft.aplication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="nota_fiscal")
public class NotaFiscal {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) 
    @Column (name = "id")
    @Getter private Integer id;

    @Column (name = "codigo") 
    @Getter @Setter private String codigo;

    @Column (name ="data") 
    @Getter @Setter private Date data;

    @OneToOne
	@JoinTable( name = "venda_nota", joinColumns = {@JoinColumn( name = "id_nota" )}, inverseJoinColumns = {@JoinColumn( name = "id_venda" )} )
    @Setter private Venda venda;
    
    @OneToOne
	@JoinTable( name = "troca_nota", joinColumns = {@JoinColumn( name = "id_nota" )}, inverseJoinColumns = {@JoinColumn( name = "id_troca" )} )
    @Setter private Troca troca;
    
    public String tipoNota(){
        if(this.troca == null){
            return "Nota de venda";
        }
        return "Nota de troca";
    }

}
