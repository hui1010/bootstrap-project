package com.example.rental.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RentCar")
public class RentCar {
    @Id
    String renterName;

    String carModel;
    LocalDate startDate;
    LocalDate endDate;

    public RentCar(String renterName, String carModel, LocalDate startDate, LocalDate endDate) {
        this.renterName = renterName;
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

    public String getCarModdl() {
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
