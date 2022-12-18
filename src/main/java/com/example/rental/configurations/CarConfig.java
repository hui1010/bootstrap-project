package com.example.rental.configurations;

import com.example.rental.entities.Car;
import com.example.rental.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CarConfig {
    @Bean
    CommandLineRunner carcommandLineRunner(CarRepository repository) {
        return args -> {
            Car volvo = new Car("Volvo S60", 1500);
            Car vw = new Car("Volkswagen Golf", 1333);
            Car mustang = new Car("Ford Mustang", 3000);
            Car transit = new Car("Ford Transit", 2400);
            repository.saveAll(List.of(volvo, vw, mustang, transit));
        };
    };
}
