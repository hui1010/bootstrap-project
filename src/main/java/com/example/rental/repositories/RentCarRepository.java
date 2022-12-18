package com.example.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.rental.entities.RentCar;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentCarRepository extends JpaRepository<RentCar, Integer> {

    @Query(value = "INSERT INTO public.rent_car ( renter_name, renter_age, car_model, start_date, end_date) VALUES (?1, ?2, ?3, ?4, ?5);", nativeQuery = true)
    RentCar saveRentCar(RentCar rentCar);

    @Query(value = "SELECT * FROM public.rent_car;", nativeQuery = true)
    List<RentCar> getAllRentCars();
}
