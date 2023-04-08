package com.imm.agroapp.services.apimeteo;

import com.imm.agroapp.entities.apimeteo.xemaMesurades.VariablesEstacio;
import com.imm.agroapp.entities.apimeteo.xemaMultiVariable.MultiVariableMesurada;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface XemaService {

    Flux<VariablesEstacio> findVariablesMesuradesEstacio(String codiEstacio);

    Mono<MultiVariableMesurada> findMultiVariablesMesuradesEstacio(String codiEstacio);
}
