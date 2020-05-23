package br.com.mrxfocus.tradingsystemmanager.service.api.service.impl;

import br.com.mrxfocus.tradingsystemmanager.service.api.component.regra.*;
import br.com.mrxfocus.tradingsystemmanager.service.api.config.Initializer;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.ConfiguracoesDaConta;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;
import br.com.mrxfocus.tradingsystemmanager.service.api.model.TradingAutorizado;
import br.com.mrxfocus.tradingsystemmanager.service.api.payload.RespostaTradingEnum;
import br.com.mrxfocus.tradingsystemmanager.service.api.payload.RespostaTradingResponse;
import br.com.mrxfocus.tradingsystemmanager.service.api.service.TradingService;
import br.com.mrxfocus.tradingsystemmanager.service.api.service.regra.ValidaRegraService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TradingServiceImpl implements TradingService {

    private ValidaRegraService validaRegraService;

    private Initializer initializer;

    public TradingServiceImpl(ValidaRegraService validaRegraService, Initializer initializer) {
        this.validaRegraService = validaRegraService;
        this.initializer = initializer;
    }

    @Override
    public Mono<RespostaTradingResponse> tradingAutorizado(Trading trading) {
        RespostaTradingResponse retorno = null;

        // configurações da conta
        ConfiguracoesDaConta configuracoesDaConta = initializer.initClass();

        // valida todas as regras
        if ( validaRegraService.validaRegra(this.regrasQueSeraoAplicadasNoTrading(), trading, configuracoesDaConta) )  {
            retorno = this.mountResponse(true);
        } else {
            retorno = this.mountResponse(false);
        }

        return Mono.just(retorno);
    }

    /**
     * aqui é dado new em todas as regras que serão aplicadas no trading
     * @return
     */
    private Regra regrasQueSeraoAplicadasNoTrading() {
        return new AltistaRegra(new BaixistaRegra(new StopEstaDentroDoAceitavelRegra(new GainEstaDentroDoAceitavelRegra())));
    }

    private RespostaTradingResponse mountResponse(Boolean autorizado) {
        if (autorizado) {
            return RespostaTradingResponse.builder().autorizado(RespostaTradingEnum.SIM).tradingAutorizado(this.mounTradingAutorizadoResponse()).build();
        }
        return RespostaTradingResponse.builder().autorizado(RespostaTradingEnum.NAO).tradingAutorizado(this.mounTradingNaoAutorizadoResponse()).build();
    }

    private TradingAutorizado mounTradingAutorizadoResponse() {
        return TradingAutorizado.builder().numeroDeContratos(2).tipoDoContrato("Mini").build();
    }

    private TradingAutorizado mounTradingNaoAutorizadoResponse() {
        return TradingAutorizado.builder().numeroDeContratos(0).tipoDoContrato("").build();
    }
}
