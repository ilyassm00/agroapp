package com.imm.agroapp.services.apimeteo;

import com.imm.agroapp.entities.apimeteo.xemaMesurades.VariablesEstacio;
import reactor.core.publisher.Flux;

public interface XemaService {

    Flux<VariablesEstacio> findVariablesMesuradesEstacio(String codiEstacio);
}
