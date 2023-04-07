package com.imm.agroapp.repositories.apimeteo;

import com.imm.agroapp.entities.apimeteo.referencia.Comarca;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComarcaRepository extends ReactiveMongoRepository<Comarca, Integer> {
}
