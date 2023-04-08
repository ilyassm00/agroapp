package com.imm.agroapp.routers;

import com.imm.agroapp.handlers.PrediccioHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class PrediccioRouter {

    @Bean
    public RouterFunction<ServerResponse> PrediccioRoute(PrediccioHandler prediccioHandler) {
        return RouterFunctions
                .route(
                    GET("/prediccioHorariaMunicipal/{codiMunicipi}")
                            .and(accept(APPLICATION_JSON)), prediccioHandler::findPrediccioHorariaMunicipal)
                .andRoute(
                    GET("/prediccioDiariaMunicipal/{codiMunicipi}")
                            .and(accept(APPLICATION_JSON)), prediccioHandler::findPrediccioDiariaMunicipal);
    }
}
