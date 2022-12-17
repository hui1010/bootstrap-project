package com.example.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.rental.entities.RentCar;

public interface AdminRepository extends JpaRepository<RentCar, Long> {

    @Query(value = "SELECT * FROM rent_car", nativeQuery = true)
    RentCar[] getAllRentedCars();
}
