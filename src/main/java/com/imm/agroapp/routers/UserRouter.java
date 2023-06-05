package com.imm.agroapp.routers;

import com.imm.agroapp.handlers.UserHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@Slf4j
public class UserRouter {

    private static final String PATH = "user/";

    @Bean
    public RouterFunction<ServerResponse> UserRoute(UserHandler userHandler) {
        return RouterFunctions
                .route()
                .PATCH(PATH + "subscribe/{username}", userHandler::subscribe)
                .PATCH(PATH + "addLocalitzacio/{username}/{codiMunicipi}", userHandler::addLocalitzacio)
                .PATCH(PATH + "removeLocalitzacio/{username}/{codiMunicipi}", userHandler::removeLocalitzacio)
                .PATCH(PATH + "addVariable/{username}/{codiVariable}", userHandler::addVariable)
                .PATCH(PATH + "removeVariable/{username}/{codiVariable}", userHandler::removeVariable)
                .GET(PATH + "{username}", userHandler::getUserByUsername)
                .build();
    }

}
