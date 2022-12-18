package com.example.rental.services;

import com.example.rental.entities.RentCar;
import com.example.rental.repositories.RentCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class RentCarService {
    public final RentCarRepository rentCarRepository;

    @Autowired
    public RentCarService(RentCarRepository rentCarRepository) {
        this.rentCarRepository = rentCarRepository;
    }

    public Optional<RentCar>  saveRentCar(RentCar rentCar) {
      //  return rentCarRepository.saveRentCar(rentCar);
        Optional<RentCar> found = rentCarRepository.getRentCarByModel(rentCar.getCarModel());
        if(found.isPresent() && found.get().getEndDate().isBefore(rentCar.getStartDate()))
            return Optional.of(null);
        return Optional.of(rentCarRepository.save(rentCar));
    }

    public List<RentCar> getAllRentCars() {
        return rentCarRepository.getAllRentCars();
    }


    public Optional<RentCar>  getRentCarByModel (String carModel) {
        return rentCarRepository.getRentCarByModel(carModel);
    }


}
