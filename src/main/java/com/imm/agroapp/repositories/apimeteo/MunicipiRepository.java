package com.imm.agroapp.repositories.apimeteo;

import com.imm.agroapp.entities.apimeteo.referencia.Municipi;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MunicipiRepository extends ReactiveMongoRepository<Municipi, Integer> {

    Flux<Municipi> findMunicipiByComarca_Codi(Integer codiComarca);
}
