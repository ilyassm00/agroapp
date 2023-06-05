package com.imm.agroapp.repositories.apimeteo;

import com.imm.agroapp.entities.apimeteo.referencia.SimbolValors;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SimbolValorsRepository extends ReactiveMongoRepository<SimbolValors, Integer> {

    Mono<SimbolValors> findSimbolValorsByCodi(Integer codi);
}
