package com.example.rental.controllers;

import com.example.rental.services.RentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.entities.RentCar;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final RentCarService rentCarService;

    @Autowired
    public AdminController(RentCarService rentCarService) {
        this.rentCarService = rentCarService;
    }

    @GetMapping
    public List<RentCar> getAllRentedCars() {
        return rentCarService.getAllRentCars();
    }
}
