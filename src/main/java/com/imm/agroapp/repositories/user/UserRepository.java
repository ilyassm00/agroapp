package com.imm.agroapp.repositories.user;

import com.imm.agroapp.entities.user.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Integer> {

    Mono<User> findByUsernameOrEmail(String username, String email);
}
