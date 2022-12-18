package com.example.rental.services;

import com.example.rental.entities.RentCar;
import com.example.rental.repositories.RentCarRepository;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RentCarServiceTest {

    @Mock private RentCarRepository rentCarRepository;
    private RentCarService underTest;

    @BeforeEach
    void setUp() {
        underTest = new RentCarService(rentCarRepository);
    }

    @Test
    void itCanGetAllRentCars() {
        underTest.getAllRentCars();
        verify(rentCarRepository).getAllRentCars();

    }
    @Test
    void itCanSaveRentCar() {
        RentCar rentCar = new RentCar("Huiyi", 25, "Ford Transit", LocalDate.of(2023,11,19), LocalDate.of(2023, 12,30));
        underTest.saveRentCar(rentCar);
        ArgumentCaptor<RentCar> rentCarArgumentCaptor = ArgumentCaptor.forClass(RentCar.class);
        verify(rentCarRepository).save(rentCarArgumentCaptor.capture());
        RentCar capturedRentCar = rentCarArgumentCaptor.getValue();
        Assert.assertEquals(capturedRentCar, rentCar);
    }
}