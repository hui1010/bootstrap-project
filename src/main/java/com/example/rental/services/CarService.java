package com.example.rental.services;


import com.example.rental.entities.Car;
import com.example.rental.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    public final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<Car> getAllCars() {
        // Besides using my own query, this should get the work down as well
        // return carRepository.findAll();
        return carRepository.getAllCars();
    }
}
