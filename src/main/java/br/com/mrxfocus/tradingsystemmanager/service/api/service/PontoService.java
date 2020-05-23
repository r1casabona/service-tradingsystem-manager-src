package br.com.mrxfocus.tradingsystemmanager.service.api.service;

import br.com.mrxfocus.tradingsystemmanager.service.api.component.ativo.Ativo;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;

import java.math.BigDecimal;

public interface PontoService {
    /**
     * caucula o valor de pontos da entrada até o stop
     * @param trading
     * @return
     */
    BigDecimal quantidadeDePontosDaEntradaAteOStop(Trading trading);

    /**
     * caucula o valor de pontos da entrada até a saida
     * @param trading
     * @return
     */
    BigDecimal quantidadeDePontosDaEntradaAteASaida(Trading trading);

    /**
     * caucula o valor do ponto
     * @param trading
     * @return
     */
    BigDecimal valorDoPonto(Trading trading);
}
