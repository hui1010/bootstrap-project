package com.example.rental.controllers;

import com.example.rental.services.RentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.rental.entities.RentCar;

@RestController
@RequestMapping("/rent")
public class RentCarController {
    private final RentCarService rentCarService;

    @Autowired
    public RentCarController(RentCarService rentCarService) {
        this.rentCarService = rentCarService;
    }

    @PostMapping
    public RentCar saveRentCar(@RequestBody RentCar rentCar) {
        return rentCarService.saveRentCar(rentCar);
    }

    /*
    @GetMapping
    public List<Car> getAllCars() {
        return rentCarService.getAllCars();
    }*/

}
