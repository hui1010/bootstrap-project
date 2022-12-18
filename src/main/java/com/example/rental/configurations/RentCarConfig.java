package com.example.rental.configurations;

import com.example.rental.entities.RentCar;
import com.example.rental.repositories.RentCarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class RentCarConfig {
    @Bean
    CommandLineRunner commandLineRunner (RentCarRepository repository) {
        return args -> {
            RentCar rentCar = new RentCar( "Huiyi", 25, "Volvo S60", LocalDate.of(2022,12,20), LocalDate.of(2022,12,30), 3000);
            repository.save(rentCar);
        };
    }
}
