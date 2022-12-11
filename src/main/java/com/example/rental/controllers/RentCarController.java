package com.example.rental.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.entities.RentCar;
import com.example.rental.repositories.RentCarRepository;

@RestController
@RequestMapping("/rent")
public class RentCarController {
    private final RentCarRepository rentCarRepository;

    public RentCarController(RentCarRepository rentCarRepository) {
        this.rentCarRepository = rentCarRepository;
    }

    @GetMapping
    public RentCar submitRentCar(RentCar rentCar) {
        return rentCarRepository.saveRentCar(rentCar);
    }
}
