package br.com.mrxfocus.tradingsystemmanager.service.api.component.ativo;

import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;

import java.math.BigDecimal;

public interface Ativo {
    /**
     * retorna o valor do ponto
     * @param trading
     * @return
     */
    BigDecimal valorPorPonto(Trading trading);

    /**
     * retorna a quantidade de pontos entre uma entrada e uma saida
     * @param trading
     * @return
     */
    BigDecimal quantidadeDePontos(BigDecimal menorValor, BigDecimal maiorValor);
}
