package com.example.rental.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.entities.RentCar;
import com.example.rental.repositories.RentCarRepository;

@RestController
@RequestMapping("/")
public class RentCarController {
    private final RentCarRepository rentCarRepository;

    public RentCarController(RentCarRepository rentCarRepository) {
        this.rentCarRepository = rentCarRepository;
    }

    @PostMapping
    public RentCar save(RentCar rentCar) {
        return rentCarRepository.saveRentCar(rentCar);
    }

    @GetMapping
    public RentCar[] getAllRentedCars() {
        return rentCarRepository.getAllRentedCars();
    }

}
