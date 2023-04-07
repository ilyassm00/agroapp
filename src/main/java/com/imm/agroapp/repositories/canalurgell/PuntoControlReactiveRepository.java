package com.imm.agroapp.repositories.canalurgell;

import com.imm.agroapp.entities.canalurgell.PuntoControl;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PuntoControlReactiveRepository extends ReactiveMongoRepository<PuntoControl, Integer> {

    Flux<PuntoControl> findAllByRemota(String remota);

    Flux<PuntoControl> findAllByRemotaAndVariable(String remota, String variable);
}
