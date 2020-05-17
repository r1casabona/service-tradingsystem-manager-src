package br.com.mrxfocus.tradingsystemmanager.service.api.config;

import br.com.mrxfocus.tradingsystemmanager.service.api.model.ConfiguracoesDaConta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Initializer {

    private BigDecimal limite;
    private BigDecimal risco;

    public Initializer(
            @Value("${tradingsystem.limite}") BigDecimal limite,
            @Value("${tradingsystem.risco}") BigDecimal risco) {

        this.limite = limite;
        this.risco = risco;
    }

    public ConfiguracoesDaConta initClass() {
        return ConfiguracoesDaConta.builder().limite(limite).risco(risco).build();
    }
}
