package br.com.mrxfocus.tradingsystemmanager.service.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ConfiguracoesDaConta {
    private BigDecimal limite;
    private BigDecimal risco;
}
