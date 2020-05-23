package br.com.mrxfocus.tradingsystemmanager.service.api.component.ativo;

import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;

import java.math.BigDecimal;

public class WIN implements Ativo {
    @Override
    public BigDecimal valorPorPonto() {
        return new BigDecimal(0.20);
    }

    @Override
    public BigDecimal quantidadeDePontos(BigDecimal entrada, BigDecimal saida) {
        // se a entrada for menor
        if ( entrada.compareTo(saida) == -1 ) {
            return saida.subtract(entrada).multiply(new BigDecimal(2)).add(new BigDecimal(1));
        }
        // caso a entrada seja maior
        return entrada.subtract(saida).multiply(new BigDecimal(2));
    }
}
