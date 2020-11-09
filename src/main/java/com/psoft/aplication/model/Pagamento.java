package com.psoft.aplication.model;

import lombok.Getter;
import lombok.Setter;


// Talvez deva ser um service de Venda
public class Pagamento {
    
    @Getter @Setter private float valor_a_pagar;
    
    @Getter @Setter private float valor_recebido;
    
    @Getter @Setter private float troco;
    
    @Getter @Setter private String tipo;
    
    public float calculaTroco(){
        return 0;
    };
}