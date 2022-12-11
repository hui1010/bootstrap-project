package com.example.rental.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rentCar")
public class RentCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    String renterName;

    @Column(nullable = false)
    int renterAge;

    @Column(nullable = false)
    String carModel;

    @Column(nullable = false)
    LocalDate startDate;

    @Column(nullable = false)
    LocalDate endDate;

    public RentCar(String renterName, int renterAge, String carModel, LocalDate startDate, LocalDate endDate) {
        this.renterName = renterName;
        this.renterAge = renterAge;
        this.carModel = carModel;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public int getRenterAge() {
        return renterAge;
    }

    public void setRenterAge(int renterAge) {
        this.renterAge = renterAge;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
