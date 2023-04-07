package com.imm.agroapp.routers;

import com.imm.agroapp.handlers.PuntoControlHandler;
import com.imm.agroapp.handlers.ReferenciaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ReferenciaRouter {

    @Bean
    public RouterFunction<ServerResponse> ReferenciaRoute(ReferenciaHandler referenciaHandler) {
        return RouterFunctions
                .route(
                        GET("/comarques/")
                                .and(accept(APPLICATION_JSON)), referenciaHandler::listComarques)
                .andRoute(
                        GET("/municipis/")
                                .and(accept(APPLICATION_JSON)), referenciaHandler::listMunicipis)
                .andRoute(
                        GET("/simbols/")
                                .and(accept(APPLICATION_JSON)), referenciaHandler::listSimbols)
                .andRoute(
                        GET("/variablesMeteo/")
                                .and(accept(APPLICATION_JSON)), referenciaHandler::listVariables)
                .andRoute(
                        GET("/estacions/")
                                .and(accept(APPLICATION_JSON)), referenciaHandler::listEstacions);
    }
}
