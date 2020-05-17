package br.com.mrxfocus.tradingsystemmanager.service.api.component.regra;

import br.com.mrxfocus.tradingsystemmanager.service.api.model.ConfiguracoesDaConta;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;

public class AltistaRegra extends Regra {

    public AltistaRegra(Regra outraRegra) {
        super(outraRegra);
    }

    public AltistaRegra() {
    }

    @Override
    public boolean valida(Trading trading, ConfiguracoesDaConta configuracoesDaConta) {
        // se o movimento for Altista devemos tratar aqui
        if ( "ALTISTA".equals(trading.getMovimento()) ) {
            // valida se Entrada é menor que a Saida
            if ( trading.getEntrada().compareTo(trading.getSaida()) == -1 ) {
                return validaOutraRegra(trading, configuracoesDaConta);
            }
            return false;
        } else {
            return validaOutraRegra(trading, configuracoesDaConta);
        }
    }
}
