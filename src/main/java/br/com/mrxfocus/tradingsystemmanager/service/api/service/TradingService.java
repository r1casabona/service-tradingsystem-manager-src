package br.com.mrxfocus.tradingsystemmanager.service.api.service;

import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;
import br.com.mrxfocus.tradingsystemmanager.service.api.payload.RespostaTradingResponse;
import reactor.core.publisher.Mono;

public interface TradingService {
    /**
     * responsável em ver se o trading está autorizado ou não
     * @param trading
     * @return
     */
    Mono<RespostaTradingResponse> tradingAutorizado(Trading trading);
}
