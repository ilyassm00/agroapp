package com.imm.agroapp.repositories.apimeteo;

import com.imm.agroapp.entities.apimeteo.referencia.Estacio;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EstacioRepository extends ReactiveMongoRepository<Estacio, String> {

    Flux<Estacio> findAllByMunicipi_Codi(Integer codiMunicipi);
}
