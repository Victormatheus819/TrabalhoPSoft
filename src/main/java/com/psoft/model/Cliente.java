package com.psoft.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table (name="cliente")
public  class Cliente {

  @Id
  @Column(name ="id") 
  @Getter @Setter private int id;
  
  @Column(name ="nome")
  @Getter @Setter private String nome;
  
  @Column(name ="cpf") 
  @Getter @Setter private String cpf;
  
  @Column(name ="email") 
  @Getter @Setter private String email;
  
  @Column(name ="endereco") 
  @Getter @Setter private String endereco;
 
  @Column(name ="telefone") 
  @Getter @Setter private String telefone;
 
  @Column(name ="preferencial") 
  @Getter @Setter private boolean peferencial;
  
  @Column(name ="pontos") 
  @Getter @Setter private int  pontos;
  
  @ManyToOne( fetch = FetchType.LAZY )
  @JoinColumn (name ="reclamacao") @Getter @Setter private List<Reclamacao> reclamacoes;

 
}
