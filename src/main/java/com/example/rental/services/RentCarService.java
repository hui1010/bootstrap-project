package com.example.rental.services;

import com.example.rental.entities.RentCar;
import com.example.rental.repositories.RentCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentCarService {
    public final RentCarRepository rentCarRepository;

    @Autowired
    public RentCarService(RentCarRepository rentCarRepository) {
        this.rentCarRepository = rentCarRepository;
    }

    public RentCar saveRentCar(RentCar rentCar) {
        return rentCarRepository.saveRentCar(rentCar);
    }

    public List<RentCar> getAllRentCars() {
        return rentCarRepository.getAllRentCars();
    }
}
