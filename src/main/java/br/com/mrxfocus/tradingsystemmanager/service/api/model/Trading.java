package br.com.mrxfocus.tradingsystemmanager.service.api.model;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Trading {
    private BigDecimal entrada;
    private BigDecimal saida;
    private BigDecimal stop;
    private String ativo;
    private String movimento;
}

