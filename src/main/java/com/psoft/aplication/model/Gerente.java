package com.psoft.aplication.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="")
public class Gerente  {
  @Id  
  @Column (name ="") @Getter @Setter private  int id ;
    
  @Column (name ="")@Getter @Setter private String nome;
    
  @Column (name ="") @Getter @Setter private String cpf;
    
  @Column (name ="") @Getter @Setter private String senha;
    
  @Column (name ="") @Getter @Setter private String endereço;
    
  @Column (name ="") @Getter @Setter private boolean ativo;



}
