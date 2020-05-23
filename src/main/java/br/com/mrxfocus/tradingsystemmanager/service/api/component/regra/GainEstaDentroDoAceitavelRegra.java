package br.com.mrxfocus.tradingsystemmanager.service.api.component.regra;

import br.com.mrxfocus.tradingsystemmanager.service.api.model.ConfiguracoesDaConta;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;
import br.com.mrxfocus.tradingsystemmanager.service.api.service.PontoService;
import br.com.mrxfocus.tradingsystemmanager.service.api.service.impl.PontoServiceImpl;

import java.math.BigDecimal;

public class GainEstaDentroDoAceitavelRegra extends Regra {

    public GainEstaDentroDoAceitavelRegra(Regra outraRegra) {
        super(outraRegra);
    }

    public GainEstaDentroDoAceitavelRegra() {
    }

    @Override
    public boolean valida(Trading trading, ConfiguracoesDaConta configuracoesDaConta) {
        // valida se o valor tem o minimo para ser lucrativo
        if ( this.valorDeGainAceitavel(trading) ) {
            return validaOutraRegra(trading, configuracoesDaConta);
        }
        return false;
    }

    private boolean valorDeGainAceitavel(Trading trading) {
        // caso seja um movimento altista a saida deve ser maior que a entrada
        if ( "ALTISTA".equals(trading.getMovimento()) ) {

            // compara se a entrada é menor que a saida
            if ( trading.getEntrada().compareTo(trading.getSaida()) == -1 ) {

                BigDecimal gain = this.cauculaOGain(trading); // cauculo qual é o gain esperado
                BigDecimal loss = this.cauculaOLoss(trading); // cauculo qual é o loss esperado

                // se o gain for menor que o loss
                if ( gain.compareTo(loss) == -1 ) {
                    return false;
                }

                return true;
            }

        } else { // caso contratio, sendo um movimento baixista a saida deve ser menor que a entrada
            // compara se a saida é menor que a entrada
            if ( trading.getSaida().compareTo(trading.getEntrada()) == -1 ) {

                BigDecimal gain = this.cauculaOGain(trading); // cauculo qual é o gain esperado
                BigDecimal loss = this.cauculaOLoss(trading); // cauculo qual é o loss esperado

                // se o gain for menor que o loss
                if ( gain.compareTo(loss) == -1 ) {
                    return false;
                }

                return true;
            }
        }
        return false;
    }

    private BigDecimal cauculaOLoss(Trading trading) {
        PontoService pontoService = new PontoServiceImpl();
        // valor do ponto
        BigDecimal valorDoPonto = pontoService.valorDoPonto(trading);
        // quantidade de pontos
        BigDecimal quantiadeDePontos = pontoService.quantidadeDePontosDaEntradaAteOStop(trading);
        // valor total do loss
        BigDecimal valorDoLoss = quantiadeDePontos.multiply(valorDoPonto);

        return valorDoLoss;
    }

    private BigDecimal cauculaOGain(Trading trading) {
        PontoService pontoService = new PontoServiceImpl();
        // valor do ponto
        BigDecimal valorDoPonto = pontoService.valorDoPonto(trading);
        // quantidade de pontos
        BigDecimal quantiadeDePontos = pontoService.quantidadeDePontosDaEntradaAteASaida(trading);
        // valor total do gain
        BigDecimal valorDoGain = quantiadeDePontos.multiply(valorDoPonto);

        return valorDoGain;
    }
}
