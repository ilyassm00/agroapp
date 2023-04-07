package com.imm.agroapp.services.canalurgell.impl;

import com.imm.agroapp.entities.canalurgell.PuntoControl;
import com.imm.agroapp.repositories.canalurgell.PuntoControlReactiveRepository;
import com.imm.agroapp.services.canalurgell.PuntoControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PuntoControlServiceImpl implements PuntoControlService {

    @Autowired
    private PuntoControlReactiveRepository puntoControlReactiveRepository;


    @Override
    public Flux<PuntoControl> findAll() {
        return puntoControlReactiveRepository.findAll();
    }

    @Override
    public Flux<String> findAllDistinctRemotas() {
        return puntoControlReactiveRepository.findAll().map(PuntoControl::getRemota).distinct();
    }

    @Override
    public Flux<String> findVariablesByRemota(String remota) {
        return puntoControlReactiveRepository.findAllByRemota(remota).map(PuntoControl::getVariable);
    }

    @Override
    public Flux<PuntoControl> findPuntoControlByRemotaAndVariable(String remota, String variable) {
        return puntoControlReactiveRepository.findAllByRemotaAndVariable(remota, variable);
    }
}
