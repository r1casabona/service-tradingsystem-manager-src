//package br.com.mrxfocus.api.tradingsystemmanager.handler;
//
//import br.com.mrxfocus.api.tradingsystemmanager.model.Trading;
//import br.com.mrxfocus.api.tradingsystemmanager.payload.RespostaTradingEnum;
//import br.com.mrxfocus.api.tradingsystemmanager.payload.RespostaTradingResponse;
//import br.com.mrxfocus.api.tradingsystemmanager.service.TradingService;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
//import java.math.BigDecimal;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.web.reactive.function.server.ServerResponse.ok;
//
//@Component
//public class TradingSystemHandler {
//
//    private TradingService tradingService;
//
//    public TradingSystemHandler(TradingService tradingService) {
//        this.tradingService = tradingService;
//    }
//
//    public Mono<ServerResponse> tradingIsValid(ServerRequest request) {
//        Mono<RespostaTradingResponse> tradingMono = Mono.just(RespostaTradingResponse.builder().resposta(RespostaTradingEnum.SIM).build());
//
//        return ok()
//                .contentType(APPLICATION_JSON)
//                .body(tradingMono, RespostaTradingResponse.class);
//    }
//
//
//}
