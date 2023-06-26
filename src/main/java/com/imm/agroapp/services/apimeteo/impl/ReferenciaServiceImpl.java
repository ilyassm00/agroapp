package com.imm.agroapp.services.apimeteo.impl;

import com.imm.agroapp.entities.apimeteo.referencia.*;
import com.imm.agroapp.repositories.apimeteo.*;
import com.imm.agroapp.services.apimeteo.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReferenciaServiceImpl implements ReferenciaService {

    @Autowired
    private MunicipiRepository municipiRepository;

    @Autowired
    private ComarcaRepository comarcaRepository;

    @Autowired
    private SimbolRepository simbolRepository;

    @Autowired
    private SimbolValorsRepository simbolValorsRepository;

    @Autowired
    private VariableRepository variableRepository;

    @Autowired
    private EstacioRepository estacioRepository;

    @Override
    public Flux<Comarca> getComarques() {
        return comarcaRepository.findAll();
    }

    @Override
    public Flux<Estacio> getEstacionsByMunicipi(Integer codiMunicipi) {
        return estacioRepository.findAllByMunicipi_Codi(codiMunicipi);
    }

    @Override
    public Flux<Municipi> getMunicipisByComarca(Integer codiComarca) {
        return municipiRepository.findMunicipiByComarca_Codi(codiComarca);
    }

    @Override
    public Mono<Municipi> getMunicipiByCod(Integer codMunicipi) {
        return municipiRepository.findById(codMunicipi);
    }

    @Override
    public Mono<Variable> getVariableByCodi(Integer codiVariable) {
        return variableRepository.findById(codiVariable);
    }

    @Override
    public Mono<Estacio> getEstacioByCodi(String codiEstacio) {
        return estacioRepository.findById(codiEstacio);
    }

    @Override
    public Mono<SimbolValors> getEstatCelByCodi(Integer codi) {
        return simbolValorsRepository.findSimbolValorsByCodi(codi);
    }
}
