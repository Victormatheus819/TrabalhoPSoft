package com.psoft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table (name= "")
public class Troca {
    @Column (name ="") @Getter @Setter private Date data ;
    @JoinColumn (name= "") @Getter @Setter Venda  venda ;
}
