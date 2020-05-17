package br.com.mrxfocus.tradingsystemmanager.service.api.component.ativo;

import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WDO implements Ativo {
    @Override
    public BigDecimal valorPorPonto(Trading trading) {
        return new BigDecimal(10);
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
