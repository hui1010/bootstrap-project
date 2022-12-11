package com.example.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.rental.entities.RentCar;

public interface RentCarRepository extends JpaRepository<RentCar, Long> {

    @Query(value = "INSERT INTO rettcar (renterName, renterAge, carModel, startDate, endDate) VALUES (?1, ?2, ?3, ?4, ?5)")
    RentCar saveRentCar(RentCar rentCar);
}
