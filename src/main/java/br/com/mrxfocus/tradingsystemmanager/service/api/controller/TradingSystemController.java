package br.com.mrxfocus.tradingsystemmanager.service.api.controller;

import br.com.mrxfocus.tradingsystemmanager.service.api.model.Trading;
import br.com.mrxfocus.tradingsystemmanager.service.api.payload.RespostaTradingResponse;
import br.com.mrxfocus.tradingsystemmanager.service.api.service.TradingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/tradingsystems", produces = MediaType.APPLICATION_JSON_VALUE)
public class TradingSystemController {

    private TradingService tradingService;

    public TradingSystemController(TradingService tradingService) {
        this.tradingService = tradingService;
    }

    @CrossOrigin
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RespostaTradingResponse> tradingSystem(@RequestBody Trading trading) {
        return tradingService.tradingAutorizado(trading);
    }
}
