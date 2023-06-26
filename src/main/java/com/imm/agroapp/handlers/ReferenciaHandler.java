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

    public Mono<ServerResponse> getEstacionsByMunicipi(ServerRequest serverRequest) {
        Integer codiMunicipi = Integer.valueOf(serverRequest.pathVariable("codiMunicipi"));
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(referenciaService.getEstacionsByMunicipi(codiMunicipi), Estacio.class);
    }

    public Mono<ServerResponse> getMunicipisByComarca(ServerRequest serverRequest) {
        Integer codiComarca = Integer.valueOf(serverRequest.pathVariable("codiComarca"));
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(referenciaService.getMunicipisByComarca(codiComarca), Municipi.class);
    }

    public Mono<ServerResponse> getMunicipiByCod(ServerRequest serverRequest) {
        Integer codiMunicipi = Integer.valueOf(serverRequest.pathVariable("codiMunicipi"));
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(referenciaService.getMunicipiByCod(codiMunicipi), Municipi.class);
    }

    public Mono<ServerResponse> getVariableByCodi(ServerRequest serverRequest) {
        Integer codiVariable = Integer.valueOf(serverRequest.pathVariable("codiVariable"));
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(referenciaService.getVariableByCodi(codiVariable), Variable.class);
    }

    public Mono<ServerResponse> getEstacioByCodi(ServerRequest serverRequest) {
        String codiEstacio = serverRequest.pathVariable("codiEstacio");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(referenciaService.getEstacioByCodi(codiEstacio), Estacio.class);
    }

    public Mono<ServerResponse> getEstatCelByCodi(ServerRequest serverRequest) {
        Integer codi = Integer.valueOf(serverRequest.pathVariable("codi"));
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(referenciaService.getEstatCelByCodi(codi), SimbolValors.class);
    }
}
