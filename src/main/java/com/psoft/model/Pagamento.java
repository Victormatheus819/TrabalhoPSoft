package com.psoft.model;

import lombok.Getter;
import lombok.Setter;

public class Pagamento {
    @Getter @Setter private float valor_a_pagar ;
    @Getter @Setter private float valor_recebido ;
    @Getter @Setter private float troco;
    @Getter @Setter private String tipo ;
    
    public float calculaTroco(){ return 0;};
}