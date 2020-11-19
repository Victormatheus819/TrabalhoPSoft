package com.psoft.aplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table (name="cliente")
public  class Cliente {

  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY )
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
 
  @Column(name ="identidade") 
  @Getter @Setter private String identidade;
 
  @Column(name ="preferencial") 
  @Getter @Setter private boolean preferencial;
  
  @Column(name ="pontos") 
  @Getter @Setter private Integer pontos;
 
}
