package com.example.rental.controllers;

import com.example.rental.entities.Car;
import com.example.rental.services.CarService;
import com.example.rental.services.RentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.rental.entities.RentCar;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rent")
public class RentCarController {
    @Autowired
    private final RentCarService rentCarService;

    @Autowired
    private final CarService carService;

    public RentCarController(RentCarService rentCarService, CarService carService) {
        this.rentCarService = rentCarService;
        this.carService = carService;
    }

    @PostMapping
    public  Optional<RentCar> saveRentCar(@RequestBody RentCar rentCar) {
/*
        System.out.println(rentCar);
        System.out.println(rentCar.getCarModel());
        Optional<RentCar> found = rentCarService.getRentCarByModel(rentCar.getCarModel());

        if(found.isPresent() && found.get().getEndDate().isBefore(rentCar.getStartDate()) ) {
            throw new Error("This car is already rented");
        }

 */
        return  rentCarService.saveRentCar(rentCar) ;
    }

    @GetMapping
    public List<Car> getAllCars() {return carService.getAllCars();}

}
