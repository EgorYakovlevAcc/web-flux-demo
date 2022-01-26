package com.example.webfluxdemo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CarRouter {
    @Bean
    public RouterFunction<ServerResponse> carRoutes(CarHandler carHandler) {
        return route().path("/v1.0/cars", builder -> builder.nest(accept(APPLICATION_JSON),
                        routerBuilder -> routerBuilder
                                .GET("/{carId}/", carHandler::getCarById)
                                .GET("/", carHandler::getAllCars)
                                .POST("/", carHandler::createCar)
                                .PUT("/", carHandler::updateCar)
                                .DELETE("/{carId}/", carHandler::deleteCar)
                ))
                .build();

    }
}
