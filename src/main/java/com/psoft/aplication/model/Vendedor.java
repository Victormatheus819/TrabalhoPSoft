package com.psoft.aplication.model;

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
public class Vendedor {
    @Id  
    @Column (name ="") @Getter @Setter private  int id ;
    
    @Column (name ="")@Getter @Setter private String nome;
    
    @Column (name ="") @Getter @Setter private String cpf;
    
    @Column (name ="") @Getter @Setter private String senha;
    
    @Column (name ="") @Getter @Setter private String endereço;
    
    @Column (name ="") @Getter @Setter private boolean ativo;

    @JoinColumn (name ="") @Getter @Setter private List<Venda> vendas;
    
    public void IniciaVenda(){}
    public void IniciaPagamento(){}
    public void finalizaCompra(){}

}
