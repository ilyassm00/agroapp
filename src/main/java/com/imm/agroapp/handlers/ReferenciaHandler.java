package com.imm.agroapp.handlers;

import com.imm.agroapp.entities.apimeteo.referencia.*;
import com.imm.agroapp.services.apimeteo.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class ReferenciaHandler {

    @Autowired
    private ReferenciaService referenciaService;

    public Mono<ServerResponse> listComarques(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(referenciaService.getComarques(), Comarca.class);
    }

    public Mono<ServerResponse> listMunicipis(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(referenciaService.getMunicipis(), Municipi.class);
    }

    public Mono<ServerResponse> listSimbols(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(referenciaService.getSimbols(), Simbol.class);
    }

    public Mono<ServerResponse> listVariables(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(referenciaService.getVariables(), Variable.class);
    }

    public Mono<ServerResponse> listEstacions(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(referenciaService.getEstacions(), Estacio.class);
    }
}
