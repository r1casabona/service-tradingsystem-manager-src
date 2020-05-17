package br.com.mrxfocus.tradingsystemmanager.service.api.service.regra;

import br.com.mrxfocus.tradingsystemmanager.service.api.component.regra.Regra;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.ConfiguracoesDaConta;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;
import org.springframework.stereotype.Service;

@Service
public class ValidaRegraService {

    public boolean validaRegra(Regra regra, Trading trading, ConfiguracoesDaConta configuracoesDaConta) {
        return regra.valida(trading, configuracoesDaConta);
    }
}
