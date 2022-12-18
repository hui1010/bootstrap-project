package com.example.rental.repositories;

import com.example.rental.entities.RentCar;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RentCarRepositoryTest {
    @Autowired
    private RentCarRepository underTest;
    RentCar rentCar1 = new RentCar("Huiyi", 25, "Ford Transit", LocalDate.of(2023,10,19), LocalDate.of(2023, 12,30));
    RentCar rentCar2 = new RentCar("Niklas", 25, "Ford Mustang", LocalDate.of(2023,10,19), LocalDate.of(2023, 10,30));

    @BeforeEach
    void setUp() {
        underTest.saveAll(List.of(rentCar1, rentCar2));
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldGetTwoRentCarsIfWeSaveTwoRentCars() {
        List<RentCar> cars =  underTest.getAllRentCars();
        Assert.assertEquals(cars.toArray().length, 2);
        Assert.assertTrue(cars.contains(rentCar1));
        Assert.assertTrue(cars.contains(rentCar2));
    }

    @Test
    void itShouldGetTheCorrectRentCarByModel() {
        Optional<RentCar> found1 = underTest.getRentCarByModel(rentCar1.getCarModel());
        Assert.assertEquals(found1.get(), rentCar1);
    }

    @Test
    void itShouldNotFindAnythingIfModelIsNotRegistedAsRentCar() {
        Optional<RentCar> found2 = underTest.getRentCarByModel("Volvo S60");
        Assert.assertFalse(found2.isPresent());
    }
}