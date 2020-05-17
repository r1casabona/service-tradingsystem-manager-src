package br.com.mrxfocus.tradingsystemmanager.service.api.component.regra;

import br.com.mrxfocus.tradingsystemmanager.service.api.model.ConfiguracoesDaConta;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;

public class BaixistaRegra extends Regra {

    public BaixistaRegra(Regra outraRegra) {
        super(outraRegra);
    }

    public BaixistaRegra() {
    }

    @Override
    public boolean valida(Trading trading, ConfiguracoesDaConta configuracoesDaConta) {
        // se o movimento for Baixista devemos tratar aqui
        if ( "BAIXISTA".equals(trading.getMovimento()) ) {
            // valida se Entrada é maior que Saida
            if ( trading.getEntrada().compareTo(trading.getSaida()) == 1 ) {
                return validaOutraRegra(trading, configuracoesDaConta);
            }
            return false;
        } else {
            return validaOutraRegra(trading, configuracoesDaConta);
        }
    }

}
