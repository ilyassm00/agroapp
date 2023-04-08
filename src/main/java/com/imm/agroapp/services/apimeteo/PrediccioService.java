package com.imm.agroapp.services.apimeteo;

import com.imm.agroapp.entities.apimeteo.prediccioDiaria.PrediccioDiariaMunicipal;
import com.imm.agroapp.entities.apimeteo.prediccioHoraria.PrediccioHorariaMunicipal;
import reactor.core.publisher.Mono;

public interface PrediccioService {

    Mono<PrediccioHorariaMunicipal> findPrediccioHorariaMunicipal(String codiMunicipi);

    Mono<PrediccioDiariaMunicipal> findPrediccioDiariaMunicipal(String codiMunicipi);
}
