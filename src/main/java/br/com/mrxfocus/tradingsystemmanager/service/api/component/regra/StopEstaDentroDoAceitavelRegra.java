package br.com.mrxfocus.tradingsystemmanager.service.api.component.regra;

import br.com.mrxfocus.tradingsystemmanager.service.api.component.ativo.WIN;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.ConfiguracoesDaConta;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;
import br.com.mrxfocus.tradingsystemmanager.service.api.component.ativo.Ativo;
import br.com.mrxfocus.tradingsystemmanager.service.api.component.ativo.WDO;
import br.com.mrxfocus.tradingsystemmanager.service.api.service.PontoService;
import br.com.mrxfocus.tradingsystemmanager.service.api.service.impl.PontoServiceImpl;

import java.math.BigDecimal;

public class StopEstaDentroDoAceitavelRegra extends Regra {

    public StopEstaDentroDoAceitavelRegra(Regra outraRegra) {
        super(outraRegra);
    }

    public StopEstaDentroDoAceitavelRegra() {
    }

    @Override
    public boolean valida(Trading trading, ConfiguracoesDaConta configuracoesDaConta) {
        // se for um movimento Altista o Stop deve ser menor que a Entrada
        if ("ALTISTA".equals(trading.getMovimento())) {
            // valida se o valor so stop esta dentro do limete paramitrizado
            if (this.limiteValidoDeStop(trading, configuracoesDaConta)) {
                // compara se o Stop é menor que a Entrada
                if (trading.getStop().compareTo(trading.getEntrada()) == -1) {
                    return validaOutraRegra(trading, configuracoesDaConta);
                }
            }
        } else { // se for um movimento Baixista o Stop deve ser maior que a Entrada
            // valida se o valor so stop esta dentro do limete paramitrizado
            if (this.limiteValidoDeStop(trading, configuracoesDaConta)) {
                // compara se o Stop é maior que a Entrada
                if (trading.getStop().compareTo(trading.getEntrada()) == 1) {
                    return validaOutraRegra(trading, configuracoesDaConta);
                }
            }
        }
        return false;
    }

    /**
     * valida se o stop representa o percentual estipulado para o trading
     *
     * @param trading
     * @return
     */
    private boolean limiteValidoDeStop(Trading trading, ConfiguracoesDaConta configuracoesDaConta) {
        BigDecimal valorPercentual = configuracoesDaConta.getLimite().multiply(configuracoesDaConta.getRisco());

        BigDecimal valorDoPonto = this.valorDoPonto(trading);
        BigDecimal quantidadeDePontosEntreAEntradaEOStop = this.calculaAQuantidadeDePontosEntreAEntradaEASaida(trading);
        BigDecimal valorDoStop = quantidadeDePontosEntreAEntradaEOStop.multiply(valorDoPonto);

        // valor do stop deve ser igual ou menor que percentual
        if (valorDoStop.compareTo(valorPercentual) == 0 ||
                valorDoStop.compareTo(valorPercentual) == -1) {
            return true;
        }

        return false;
    }

    // calcula a quantidade de pontos entre a entrada e o stop
    private BigDecimal calculaAQuantidadeDePontosEntreAEntradaEASaida(Trading trading) {
        PontoService pontoService = new PontoServiceImpl();
        return pontoService.quantidadeDePontosDaEntradaAteASaida(trading);
    }

    /**
     * retorna o valor do ponto de acordo como ativo que foi informado no trading
     *
     * @param trading
     * @return
     */
    protected BigDecimal valorDoPonto(Trading trading) {
        PontoService pontoService = new PontoServiceImpl();
        return pontoService.valorDoPonto(trading);
    }
}
