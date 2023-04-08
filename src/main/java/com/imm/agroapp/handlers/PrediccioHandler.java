package com.imm.agroapp.handlers;

import com.imm.agroapp.entities.apimeteo.prediccioDiaria.PrediccioDiariaMunicipal;
import com.imm.agroapp.entities.apimeteo.prediccioHoraria.PrediccioHorariaMunicipal;
import com.imm.agroapp.entities.apimeteo.prediccioUvi.PrediccioUviMunicipal;
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
                .body(prediccioService.findPrediccioHorariaMunicipal(codiMunicipi), PrediccioHorariaMunicipal.class);
    }

    public Mono<ServerResponse> findPrediccioDiariaMunicipal(ServerRequest serverRequest) {
        String codiMunicipi = serverRequest.pathVariable("codiMunicipi");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(prediccioService.findPrediccioDiariaMunicipal(codiMunicipi), PrediccioDiariaMunicipal.class);
    }

    public Mono<ServerResponse> findPrediccioUviMunicipal(ServerRequest serverRequest) {
        String codiMunicipi = serverRequest.pathVariable("codiMunicipi");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(prediccioService.findPrediccioUviMunicipal(codiMunicipi), PrediccioUviMunicipal.class);
    }
}
