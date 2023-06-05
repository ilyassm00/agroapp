package com.imm.agroapp.handlers;

import com.imm.agroapp.dto.TokenDTO;
import com.imm.agroapp.entities.user.User;
import com.imm.agroapp.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserHandler {

    private final UserService userService;



    public Mono<ServerResponse> subscribe(ServerRequest request) {
        String username = request.pathVariable("username");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(userService.subscribe(username), TokenDTO.class);
    }

    public Mono<ServerResponse> addLocalitzacio(ServerRequest request) {
        String username = request.pathVariable("username");
        Integer codiMunicipi = Integer.valueOf(request.pathVariable("codiMunicipi"));
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(userService.addLocalitzacio(username, codiMunicipi), Integer.class);
    }

    public Mono<ServerResponse> removeLocalitzacio(ServerRequest request) {
        String username = request.pathVariable("username");
        Integer codiMunicipi = Integer.valueOf(request.pathVariable("codiMunicipi"));
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(userService.removeLocalitzacio(username, codiMunicipi), Integer.class);
    }

    public Mono<ServerResponse> addVariable(ServerRequest request) {
        String username = request.pathVariable("username");
        Integer codiVariable = Integer.valueOf(request.pathVariable("codiVariable"));
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(userService.addVariable(username, codiVariable), Integer.class);
    }

    public Mono<ServerResponse> removeVariable(ServerRequest request) {
        String username = request.pathVariable("username");
        Integer codiVariable = Integer.valueOf(request.pathVariable("codiVariable"));
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(userService.removeVariable(username, codiVariable), Integer.class);
    }

    public Mono<ServerResponse> getUserByUsername(ServerRequest request) {
        String username = request.pathVariable("username");
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(userService.getUserByUsername(username), User.class);
    }
}
