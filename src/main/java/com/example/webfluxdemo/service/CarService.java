package com.example.webfluxdemo.service;

import com.example.webfluxdemo.model.Car;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarService {
    Mono<Car> createCar(Car car);
    Mono<Car> updateCar(Car car);
    Mono<Car> getCarById(Long id);
    Flux<Car> getAllCars();
    Mono deleteCarById(Long id);
}
