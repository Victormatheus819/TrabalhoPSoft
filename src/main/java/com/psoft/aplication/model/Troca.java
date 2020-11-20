package com.psoft.aplication.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name= "troca")
public class Troca {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) 
    @Column (name = "id") 
    @Getter Integer id;

    @Column (name ="data") 
    @Getter @Setter private Date data ;
    
    @ManyToOne
    @JoinColumn (name= "id_venda") 
    @Getter @Setter Venda venda;

    @ManyToMany
	@JoinTable( name = "troca_item", joinColumns = {@JoinColumn( name = "id_troca" )}, inverseJoinColumns = {@JoinColumn( name = "id_item" )} )
    @Getter @Setter private List<Item> itens;
    
    @OneToOne
	@JoinTable( name = "troca_item", joinColumns = {@JoinColumn( name = "id_troca" )}, inverseJoinColumns = {@JoinColumn( name = "id_nota" )} )
	@Getter @Setter private NotaFiscal notaFiscal;

}
