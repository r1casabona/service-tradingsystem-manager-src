package br.com.mrxfocus.tradingsystemmanager.service.api.component.regra;

import br.com.mrxfocus.tradingsystemmanager.service.api.model.ConfiguracoesDaConta;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;

public abstract class Regra {
    protected Regra outraRegra;

    public Regra(Regra outraRegra) {
        this.outraRegra = outraRegra;
    }

    public Regra() {
    }

    /**
     * valida a regra, utilizando o designer pattern Decorator
     * @param trading
     * @return
     */
    public abstract boolean valida(Trading trading, ConfiguracoesDaConta configuracoesDaConta);

    protected boolean validaOutraRegra(Trading trading, ConfiguracoesDaConta configuracoesDaConta) {
        if(outraRegra == null) return true;
        return outraRegra.valida(trading, configuracoesDaConta);
    }

}
