package com.psoft.aplication.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity 
@Table (name="")
public class Vendedor extends Usuario {
    @JoinColumn (name ="") @Getter @Setter private List<Venda> vendas;
    
    public void IniciaVenda(){}
    public void IniciaPagamento(){}
    public void finalizaCompra(){}

}
