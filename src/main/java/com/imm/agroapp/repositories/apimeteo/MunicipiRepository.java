package com.imm.agroapp.repositories.apimeteo;

import com.imm.agroapp.entities.apimeteo.referencia.Municipi;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipiRepository extends ReactiveMongoRepository<Municipi, Integer> {
}
