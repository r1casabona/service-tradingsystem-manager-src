package br.com.mrxfocus.tradingsystemmanager.service.api.service.impl;

import br.com.mrxfocus.tradingsystemmanager.service.api.component.ativo.Ativo;
import br.com.mrxfocus.tradingsystemmanager.service.api.component.ativo.WDO;
import br.com.mrxfocus.tradingsystemmanager.service.api.component.ativo.WIN;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;
import br.com.mrxfocus.tradingsystemmanager.service.api.service.PontoService;

import java.math.BigDecimal;

public class PontoServiceImpl implements PontoService {
    @Override
    public BigDecimal quantidadeDePontosDaEntradaAteOStop(Trading trading) {
        if (trading.getAtivo().equals("WDO")) {
            Ativo wdo = new WDO();
            return wdo.quantidadeDePontos(trading.getEntrada(), trading.getStop());
        }
        Ativo win = new WIN();
        return win.quantidadeDePontos(trading.getEntrada(), trading.getStop());
    }

    @Override
    public BigDecimal quantidadeDePontosDaEntradaAteASaida(Trading trading) {
        if (trading.getAtivo().equals("WDO")) {
            Ativo wdo = new WDO();
            return wdo.quantidadeDePontos(trading.getEntrada(), trading.getSaida());
        }
        Ativo win = new WIN();
        return win.quantidadeDePontos(trading.getEntrada(), trading.getSaida());
    }

    @Override
    public BigDecimal valorDoPonto(Trading trading) {
        if (trading.getAtivo().equals("WDO")) {
            Ativo wdo = new WDO();
            return wdo.valorPorPonto();
        }
        Ativo win = new WIN();
        return win.valorPorPonto();
    }


}
