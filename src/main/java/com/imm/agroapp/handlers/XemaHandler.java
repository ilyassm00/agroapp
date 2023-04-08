package com.imm.agroapp.handlers;

import com.imm.agroapp.entities.apimeteo.xemaMesurades.VariablesEstacio;
import com.imm.agroapp.entities.apimeteo.xemaMultiVariable.MultiVariableMesurada;
import com.imm.agroapp.services.apimeteo.XemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class XemaHandler {

    @Autowired
    private XemaService xemaService;

    public Mono<ServerResponse> findVariablesMesuradesEstacio(ServerRequest serverRequest) {
        String codiMunicipi = serverRequest.pathVariable("codiMunicipi");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(xemaService.findVariablesMesuradesEstacio(codiMunicipi), VariablesEstacio.class);
    }

    public Mono<ServerResponse> findMultiVariablesMesuradesEstacio(ServerRequest serverRequest) {
        String codiMunicipi = serverRequest.pathVariable("codiMunicipi");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(xemaService.findMultiVariablesMesuradesEstacio(codiMunicipi), MultiVariableMesurada.class);
    }
}
