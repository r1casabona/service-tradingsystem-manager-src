package br.com.mrxfocus.tradingsystemmanager.service.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TradingAutorizado {
    private int numeroDeContratos;
    private String tipoDoContrato;
}
