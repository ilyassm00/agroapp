package com.imm.agroapp.repositories.canalurgell;

import com.imm.agroapp.entities.canalurgell.PuntoControl;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuntoControlRepository extends MongoRepository<PuntoControl, Integer> {
}
