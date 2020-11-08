package com.psoft.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name= "")
public class Venda {
    @Id
    @Column (name ="") @Getter @Setter private Date data;
    
    @Column (name ="") @Getter @Setter private String status;
    
    @JoinColumn (name ="") @Getter @Setter private Cliente cliente; 
    
    @JoinColumn (name ="") @Getter @Setter private Pagamento pagamento;
    
    @JoinColumn (name ="") @Getter @Setter private List<Troca>  troca;
    
    @JoinColumn (name ="") @Getter @Setter private List<ItemVenda> itemVenda;

   public float calculaValorTotal (){return 0;};
   public void  gerarNotaFiscal (){};
   public float calculaDesconto () {return 0;};
   public int   gerarPontos (){ return 0;};
    
}
