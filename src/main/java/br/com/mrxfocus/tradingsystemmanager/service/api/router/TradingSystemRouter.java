//package br.com.mrxfocus.api.tradingsystemmanager.router;
//
//import br.com.mrxfocus.api.tradingsystemmanager.handler.TradingSystemHandler;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//import static org.springframework.web.reactive.function.server.RequestPredicates.*;
//
//@Configuration
//public class TradingSystemRouter {
//    @Value("${base.path}")
//    private String basePath;
//
//    private TradingSystemHandler tradingSystemHandler;
//
//    public TradingSystemRouter(TradingSystemHandler tradingSystemHandler) {
//        this.tradingSystemHandler = tradingSystemHandler;
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> tradingSystemRoutes() {
//        return RouterFunctions.route()
//                .path(basePath.concat("/tradingsystem"), builder -> builder
//                        .POST("/", accept(MediaType.APPLICATION_JSON), tradingSystemHandler::tradingIsValid)
//                        .GET("/", accept(MediaType.APPLICATION_JSON), tradingSystemHandler::tradingIsValid))
//                .build();
//    }
//}
