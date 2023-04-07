package com.imm.agroapp.handlers;

import com.imm.agroapp.entities.apimeteo.referencia.*;
import com.imm.agroapp.services.apimeteo.PrediccioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class PrediccioHandler {

    @Autowired
    private PrediccioService prediccioService;

    public Mono<ServerResponse> findPrediccioHorariaMunicipal(ServerRequest serverRequest) {
        String codiMunicipi = serverRequest.pathVariable("codiMunicipi");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(prediccioService.findPrediccioHorariaMunicipal(codiMunicipi), Comarca.class);
    }
}
