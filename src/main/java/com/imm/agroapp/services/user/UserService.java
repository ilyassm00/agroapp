package com.imm.agroapp.services.user;

import com.imm.agroapp.dto.CreateUserDTO;
import com.imm.agroapp.dto.LoginDTO;
import com.imm.agroapp.dto.TokenDTO;
import com.imm.agroapp.entities.user.User;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<TokenDTO> login(LoginDTO dto);

    Mono<User> create(CreateUserDTO dto);

    Mono<TokenDTO> subscribe(String username);

    Mono<Integer> addLocalitzacio(String username, Integer codiMunicipi);

    Mono<Integer> removeLocalitzacio(String username, Integer codiMunicipi);

    Mono<Integer> addVariable(String username, Integer codiVariable);

    Mono<Integer> removeVariable(String username, Integer codiVariable);

    Mono<User> getUserByUsername(String username);
}
