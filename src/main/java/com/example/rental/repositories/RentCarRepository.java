package com.example.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.rental.entities.RentCar;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentCarRepository extends JpaRepository<RentCar, Integer> {

    /*
    @Query(value = "INSERT INTO public.rent_car ( renter_name, renter_age, car_model, start_date, end_date, cost) VALUES (?1, ?2, ?3, ?4, ?5, ?6);", nativeQuery = true)
    RentCar saveRentCar(RentCar rentCar);
    */

    @Query(value = "SELECT * FROM public.rent_car;", nativeQuery = true)
    List<RentCar> getAllRentCars();

    @Query(value = "SELECT * FROM public.rent_car rc WHERE rc.car_model = ?1", nativeQuery = true)
    Optional<RentCar> getRentCarByModel(String model);
}
