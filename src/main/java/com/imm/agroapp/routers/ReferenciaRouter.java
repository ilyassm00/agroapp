package com.imm.agroapp.routers;

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
                    GET("/variablesMeteo/{codiVariable}")
                            .and(accept(APPLICATION_JSON)), referenciaHandler::getVariableByCodi)
                .andRoute(
                    GET("/estacions/municipi/{codiMunicipi}")
                            .and(accept(APPLICATION_JSON)), referenciaHandler::getEstacionsByMunicipi)
                .andRoute(
                    GET("/municipis/comarca/{codiComarca}")
                            .and(accept(APPLICATION_JSON)), referenciaHandler::getMunicipisByComarca)
                .andRoute(
                    GET("/municipis/{codiMunicipi}")
                            .and(accept(APPLICATION_JSON)), referenciaHandler::getMunicipiByCod)
                .andRoute(
                    GET("/estacions/{codiEstacio}")
                            .and(accept(APPLICATION_JSON)), referenciaHandler::getEstacioByCodi)
                .andRoute(
                        GET("/estatCel/{codi}")
                                .and(accept(APPLICATION_JSON)), referenciaHandler::getEstatCelByCodi);
    }
}
