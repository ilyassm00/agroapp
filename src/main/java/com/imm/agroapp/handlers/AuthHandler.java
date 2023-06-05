package com.imm.agroapp.handlers;

import com.imm.agroapp.dto.CreateUserDTO;
import com.imm.agroapp.dto.LoginDTO;
import com.imm.agroapp.dto.TokenDTO;
import com.imm.agroapp.entities.apimeteo.prediccioUvi.PrediccioUviMunicipal;
import com.imm.agroapp.entities.user.User;
import com.imm.agroapp.services.user.UserService;
import com.imm.agroapp.validation.ObjectValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthHandler {

    private final UserService userService;

    private final ObjectValidator objectValidator;

    public Mono<ServerResponse> login(ServerRequest request) {
        Mono<LoginDTO> dtoMono = request.bodyToMono(LoginDTO.class).doOnNext(objectValidator::validate);
        return dtoMono
                .flatMap(dto -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userService.login(dto), TokenDTO.class));
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<CreateUserDTO> dtoMono = request.bodyToMono(CreateUserDTO.class).doOnNext(objectValidator::validate);
        return dtoMono
                .flatMap(dto -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userService.create(dto), User.class));
    }
}
