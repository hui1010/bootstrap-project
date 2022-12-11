package com.example.rental.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rental.entities.RentCar;
import com.example.rental.repositories.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping
    public RentCar[] getRentCars() {
        return adminRepository.getAllRentCars();
    }
}
