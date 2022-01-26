package com.example.webfluxdemo.service;

import com.example.webfluxdemo.model.Car;
import com.example.webfluxdemo.repo.CarRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Mono<Car> createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Mono<Car> updateCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Mono<Car> getCarById(Long id) {
        return carRepository.findCarById(id);
    }

    @Override
    public Flux<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Mono deleteCarById(Long id) {
        return carRepository.deleteCarById(id);
    }
}
