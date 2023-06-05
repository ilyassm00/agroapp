package com.imm.agroapp.services.apimeteo;

import com.imm.agroapp.entities.apimeteo.referencia.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReferenciaService {

    Flux<Comarca> getComarques();

    Flux<Municipi> getMunicipis();

    Flux<Simbol> getSimbols();

    Flux<Variable> getVariables();

    Flux<Estacio> getEstacions();

    Flux<Estacio> getEstacionsByMunicipi(Integer codiMunicipi);

    Flux<Municipi> getMunicipisByComarca(Integer codiComarca);

    Mono<Municipi> getMunicipiByCod(Integer codMunicipi);

    Mono<Variable> getVariableByCodi(Integer codiVariable);

    Mono<Estacio> getEstacioByCodi(String codiEstacio);

    Mono<SimbolValors> getEstatCelByCodi(Integer codi);
}
