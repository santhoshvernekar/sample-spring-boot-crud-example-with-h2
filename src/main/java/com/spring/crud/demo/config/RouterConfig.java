package com.spring.crud.demo.config;

import com.spring.crud.demo.handler.SportsIconHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@AllArgsConstructor
public class RouterConfig {

    private final SportsIconHandler sportsIconHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {

        return RouterFunctions.route()
                .GET("/route/sport-icons", sportsIconHandler::findAll)
                .GET("/route/sport-icons/{id}", sportsIconHandler::findById)
                .POST("/route/sport-icons", sportsIconHandler::save)
                .PUT("/route/sport-icons/{id}", sportsIconHandler::update)
                .DELETE("/route/sport-icons/{id}", sportsIconHandler::delete)
                .build();
    }
}
