package com.psoft.aplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="gerente")
public class Gerente  {

  @Id  
  @GeneratedValue( strategy = GenerationType.IDENTITY ) 
  @Column (name ="id")
  @Getter private Integer id ;
    
  @Column (name ="nome")
  @Getter @Setter private String nome;
    
  @Column (name ="codigo") 
  @Getter @Setter private String codigo;
    
  @Column (name ="ativo") 
  @Getter @Setter private boolean ativo;
      
  @Column (name ="senha") 
  @Getter @Setter private String senha;

}
