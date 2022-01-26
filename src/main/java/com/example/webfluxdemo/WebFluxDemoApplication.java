package com.example.webfluxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;


@SpringBootApplication
public class WebFluxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebFluxDemoApplication.class, args);
    }

}
