package com.example.rental.services;

import com.example.rental.repositories.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class CarServiceTest {

    @Mock private CarRepository carRepository;
    private AutoCloseable autoCloseable;
    private CarService underTest;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks((this));
        underTest = new CarService(carRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void itGetsAllCars() {
        underTest.getAllCars();
        verify(carRepository).getAllCars();
    }
}