package com.example.webfluxdemo.config;

import com.example.webfluxdemo.controller.CarHandler;
import com.example.webfluxdemo.repo.CarRepository;
import com.example.webfluxdemo.service.CarService;
import com.example.webfluxdemo.service.CarServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public CarService carService(CarRepository carRepository) {
        return new CarServiceImpl(carRepository);
    }

    @Bean
    public CarHandler carHandler(CarService carService) {
        return new CarHandler(carService);
    }
}
