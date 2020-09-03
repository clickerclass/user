package com.clickerclass.user.config;

import com.clickerclass.user.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> routesUser(UserHandler userHandler) {
        return RouterFunctions
                .route(GET("/api/user/findById"), userHandler::findById)
                .andRoute(POST("/api/user"), userHandler::save)
                .andRoute(GET("/api/user/findByEmail"), userHandler::findByEmail)
                .andRoute(GET("/api/userwithpassword"), userHandler::findByEmailWithPassword);
    }

}
