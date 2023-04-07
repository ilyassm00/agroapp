package com.imm.agroapp.services.canalurgell;

import com.imm.agroapp.entities.canalurgell.PuntoControl;
import reactor.core.publisher.Flux;

public interface PuntoControlService {

    Flux<PuntoControl> findAll();

    Flux<String> findAllDistinctRemotas();

    Flux<String> findVariablesByRemota(String remota);

    Flux<PuntoControl> findPuntoControlByRemotaAndVariable(String remota, String variable);
}
