package com.imm.agroapp.services.apimeteo.impl;

import com.imm.agroapp.entities.apimeteo.referencia.*;
import com.imm.agroapp.repositories.apimeteo.*;
import com.imm.agroapp.services.apimeteo.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ReferenciaServiceImpl implements ReferenciaService {

    @Autowired
    private MunicipiRepository municipiRepository;

    @Autowired
    private ComarcaRepository comarcaRepository;

    @Autowired
    private SimbolRepository simbolRepository;

    @Autowired
    private VariableRepository variableRepository;

    @Autowired
    private EstacioRepository estacioRepository;

    @Override
    public Flux<Comarca> getComarques() {
        return comarcaRepository.findAll();
    }

    @Override
    public Flux<Municipi> getMunicipis() {
        return municipiRepository.findAll();
    }

    @Override
    public Flux<Simbol> getSimbols() {
        return simbolRepository.findAll();
    }

    @Override
    public Flux<Variable> getVariables() {
        return variableRepository.findAll();
    }

    @Override
    public Flux<Estacio> getEstacions() {
        return estacioRepository.findAll();
    }

    @Override
    public Flux<Estacio> getEstacionsByMunicipi(Integer codiMunicipi) {
        return estacioRepository.findAllByMunicipi_Codi(codiMunicipi);
    }
}
