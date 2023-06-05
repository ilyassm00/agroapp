package com.imm.agroapp.services.user.impl;

import com.imm.agroapp.config.jwt.JwtProvider;
import com.imm.agroapp.dto.CreateUserDTO;
import com.imm.agroapp.dto.LoginDTO;
import com.imm.agroapp.dto.TokenDTO;
import com.imm.agroapp.entities.user.User;
import com.imm.agroapp.exceptions.CustomException;
import com.imm.agroapp.repositories.user.UserRepository;
import com.imm.agroapp.services.user.UserService;
import com.imm.agroapp.utilities.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JwtProvider jwtProvider;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Mono<TokenDTO> login(LoginDTO dto) {
        return userRepository.findByUsernameOrEmail(dto.getUsername(), dto.getUsername())
                .filter(user -> passwordEncoder.matches(dto.getPassword(), user.getPassword()))
                .map(user -> new TokenDTO(jwtProvider.generateToken(user)))
                .switchIfEmpty(Mono.error(new CustomException(HttpStatus.BAD_REQUEST, "Credencials incorrectes")));
    }

    @Override
    public Mono<User> create(CreateUserDTO dto) {
        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .localitzacions(new ArrayList<>())
                .variables(new ArrayList<>())
                .roles(Role.ROLE_USER.name())
                .build();
        Mono<Boolean> userExists = userRepository.findByUsernameOrEmail(user.getUsername(), user.getEmail()).hasElement();
        return userExists
                .flatMap(exists -> exists ?
                        Mono.error(new CustomException(HttpStatus.BAD_REQUEST, "El nom d'usuari o l'email ja existeix"))
                        : userRepository.save(user));
    }

    @Override
    public Mono<TokenDTO> subscribe(String username) {
        return userRepository.findByUsernameOrEmail(username, username)
                .flatMap( user -> {
                    user.setRoles(user.getRoles() + ", " + Role.ROLE_PREMIUM);
                    return userRepository.save(user);
                })
                .map(user -> new TokenDTO(jwtProvider.generateToken(user)))
                .switchIfEmpty(Mono.error(new CustomException(HttpStatus.NOT_FOUND, "L'usuari no existeix")));
    }

    @Override
    public Mono<Integer> addLocalitzacio(String username, Integer codiMunicipi) {
        return userRepository.findByUsernameOrEmail(username, username)
                .flatMap( user -> {
                    List<Integer> localitzacions = user.getLocalitzacions();
                    localitzacions.add(codiMunicipi);
                    user.setLocalitzacions(localitzacions);
                    return userRepository.save(user);
                })
                .map(user -> codiMunicipi)
                .switchIfEmpty(Mono.error(new CustomException(HttpStatus.NOT_FOUND, "L'usuari no existeix")));
    }

    @Override
    public Mono<Integer> removeLocalitzacio(String username, Integer codiMunicipi) {
        return userRepository.findByUsernameOrEmail(username, username)
                .flatMap( user -> {
                    List<Integer> localitzacions = user.getLocalitzacions();
                    localitzacions.remove(codiMunicipi);
                    user.setLocalitzacions(localitzacions);
                    return userRepository.save(user);
                })
                .map(user -> codiMunicipi)
                .switchIfEmpty(Mono.error(new CustomException(HttpStatus.NOT_FOUND, "L'usuari no existeix")));
    }

    @Override
    public Mono<Integer> addVariable(String username, Integer codiVariable) {
        return userRepository.findByUsernameOrEmail(username, username)
                .flatMap( user -> {
                    List<Integer> variables = user.getVariables();
                    variables.add(codiVariable);
                    user.setVariables(variables);
                    return userRepository.save(user);
                })
                .map(user -> codiVariable)
                .switchIfEmpty(Mono.error(new CustomException(HttpStatus.NOT_FOUND, "L'usuari no existeix")));
    }

    @Override
    public Mono<Integer> removeVariable(String username, Integer codiVariable) {
        return userRepository.findByUsernameOrEmail(username, username)
                .flatMap( user -> {
                    List<Integer> variables = user.getVariables();
                    variables.remove(codiVariable);
                    user.setVariables(variables);
                    return userRepository.save(user);
                })
                .map(user -> codiVariable)
                .switchIfEmpty(Mono.error(new CustomException(HttpStatus.NOT_FOUND, "L'usuari no existeix")));
    }

    @Override
    public Mono<User> getUserByUsername(String username) {
        return userRepository.findByUsernameOrEmail(username, username)
                .switchIfEmpty(Mono.error(new CustomException(HttpStatus.NOT_FOUND, "L'usuari no existeix")));
    }
}