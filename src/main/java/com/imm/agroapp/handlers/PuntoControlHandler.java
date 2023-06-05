package com.imm.agroapp.handlers;

import com.imm.agroapp.entities.canalurgell.PuntoControl;
import com.imm.agroapp.services.canalurgell.PuntoControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class PuntoControlHandler {

    @Autowired
    private PuntoControlService puntoControlService;

    private Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    public Mono<ServerResponse> listPuntosControl(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(puntoControlService.findAll(), PuntoControl.class)
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> listRemotas(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(puntoControlService.findAllDistinctRemotas(), String.class)
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> listVariablesByRemota(ServerRequest serverRequest) {
        String remota = serverRequest.pathVariable("remota");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(puntoControlService.findVariablesByRemota(remota), String.class)
                .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> getPuntoControlByRemotaAndVariable(ServerRequest serverRequest) {
        String remota = serverRequest.pathVariable("remota");
        String variable = serverRequest.pathVariable("variable");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(puntoControlService.findPuntoControlByRemotaAndVariable(remota, variable), PuntoControl.class)
                .switchIfEmpty(notFound);
    }
}
