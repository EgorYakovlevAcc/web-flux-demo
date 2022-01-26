package com.example.webfluxdemo.repo;

import com.example.webfluxdemo.model.Car;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CarRepository extends ReactiveCrudRepository<Car, Long> {
    Mono<Car> findCarById(Long id);
    Mono<Void> deleteCarById(Long id);
}
