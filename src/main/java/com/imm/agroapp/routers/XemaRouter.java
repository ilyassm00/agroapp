package com.imm.agroapp.routers;

import com.imm.agroapp.handlers.XemaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class XemaRouter {

    @Bean
    public RouterFunction<ServerResponse> XemaRoute(XemaHandler xemaHandler) {
        return RouterFunctions
                .route(
                    GET("/estacions/{codiMunicipi}/variables")
                            .and(accept(APPLICATION_JSON)), xemaHandler::findVariablesMesuradesEstacio);
    }
}
