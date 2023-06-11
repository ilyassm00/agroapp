package com.imm.agroapp.services.canalurgell;

import com.imm.agroapp.entities.canalurgell.PuntoControl;
import reactor.core.publisher.Flux;

public interface PuntoControlService {

    Flux<PuntoControl> findAll();
}
