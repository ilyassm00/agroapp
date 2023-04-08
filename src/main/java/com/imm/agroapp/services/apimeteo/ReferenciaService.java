package com.imm.agroapp.services.apimeteo;

import com.imm.agroapp.entities.apimeteo.referencia.*;
import reactor.core.publisher.Flux;

public interface ReferenciaService {

    Flux<Comarca> getComarques();

    Flux<Municipi> getMunicipis();

    Flux<Simbol> getSimbols();

    Flux<Variable> getVariables();

    Flux<Estacio> getEstacions();

    Flux<Estacio> getEstacionsByMunicipi(Integer codiMunicipi);
}
