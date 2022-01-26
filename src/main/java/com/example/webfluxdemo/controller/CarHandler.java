package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.model.Car;
import com.example.webfluxdemo.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class CarHandler {
    private CarService carService;

    public CarHandler(CarService carService) {
        this.carService = carService;
    }

    public Mono<ServerResponse> getCarById(ServerRequest serverRequest) {
        Long carId = Long.parseLong(serverRequest.pathVariable("carId"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(carService.getCarById(carId), Car.class);
    }

    public Mono<ServerResponse> getAllCars(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(carService.getAllCars(), Car.class);
    }

    public Mono<ServerResponse> createCar(ServerRequest serverRequest) {
        Mono<Car> createdCar = serverRequest.bodyToMono(Car.class)
                .flatMap(car -> carService.createCar(car));

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createdCar, Car.class);
    }

    public Mono<ServerResponse> updateCar(ServerRequest serverRequest) {
        Mono<Car> createdCar = serverRequest.bodyToMono(Car.class)
                .flatMap(car -> carService.updateCar(car));

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createdCar, Car.class);
    }

    public Mono<ServerResponse> deleteCar(ServerRequest serverRequest) {
        Long carId = Long.parseLong(serverRequest.pathVariable("carId"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(carService.deleteCarById(carId), Car.class);
    }
}
