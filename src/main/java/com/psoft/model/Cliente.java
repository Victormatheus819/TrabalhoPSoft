package com.psoft.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Table (name="")
public  class Cliente {
  @Id
  @Column (name ="") @Getter @Setter private  int id ;
  
  @Column (name ="")@Getter @Setter private String nome;
  
  @Column (name ="") @Getter @Setter private String cpf;
  
  @Column (name ="") @Getter @Setter private String email;
  
  @Column (name ="") @Getter @Setter private String endereço;
 
  @Column (name ="") @Getter @Setter private String telefone;
 
  @Column (name ="") @Getter @Setter private boolean peferencial;
  
  @Column (name ="") @Getter @Setter private int  pontos;
  
  @JoinColumn (name ="") @Getter @Setter private List<Reclamacao> reclamacoes;

 
}
