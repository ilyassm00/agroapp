package com.imm.agroapp.routers;

import com.imm.agroapp.handlers.PuntoControlHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Configuration
public class PuntoControlRouter {

    @Bean
    public RouterFunction<ServerResponse> PuntoControlRoute(PuntoControlHandler puntoControlHandler) {
        return RouterFunctions
                .route(
                    GET("/puntosControl/")
                            .and(accept(APPLICATION_JSON)), puntoControlHandler::listPuntosControl);
    }
}
