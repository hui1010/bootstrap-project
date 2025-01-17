package com.example.rental.services;

import com.example.rental.entities.RentCar;
import com.example.rental.repositories.RentCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentCarService {
    public final RentCarRepository rentCarRepository;

    @Autowired
    public RentCarService(RentCarRepository rentCarRepository) {
        this.rentCarRepository = rentCarRepository;
    }

    public RentCar saveRentCar(RentCar rentCar) {

     Optional<RentCar> found = rentCarRepository.getRentCarByModel(rentCar.getCarModel());
        if(found.isPresent() && found.get().getEndDate().isBefore(rentCar.getStartDate()))
         throw new IllegalStateException("This car is already rented");

        return rentCarRepository.save(rentCar);
    }

    public List<RentCar> getAllRentCars() {
        return rentCarRepository.getAllRentCars();
    }
}
