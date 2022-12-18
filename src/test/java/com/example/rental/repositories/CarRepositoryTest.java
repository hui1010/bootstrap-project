package com.example.rental.repositories;

import com.example.rental.entities.Car;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {
    @Autowired
    private CarRepository underTest;
    Car volvo = new Car("Volvo S60", 1500);
    Car vw = new Car("Volkswagen Golf", 1333);
    Car mustang = new Car("Ford Mustang", 3000);
    Car transit = new Car("Ford Transit", 2400);

    @BeforeEach
    void setUp() {
        underTest.saveAll(List.of(volvo, vw, mustang, transit));
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldReturnAllFourCarsSavedInDb() {
        List<Car> cars = underTest.getAllCars();
        Assert.assertEquals(cars.toArray().length, 4);
        Assert.assertTrue(cars.contains(volvo));
        Assert.assertTrue(cars.contains(vw));
        Assert.assertTrue(cars.contains(mustang));
        Assert.assertTrue(cars.contains(transit));
    }

    @Test
    void itShouldReturnThreeCarsAfterDeletingOne() {
        underTest.delete(transit);
        List<Car> cars = underTest.getAllCars();
        Assert.assertEquals(cars.toArray().length, 3);
        Assert.assertTrue(cars.contains(volvo));
        Assert.assertTrue(cars.contains(vw));
        Assert.assertTrue(cars.contains(mustang));
    }

}