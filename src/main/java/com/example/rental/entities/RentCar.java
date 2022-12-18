package com.example.rental.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rentCar")
public class RentCar {
    @Id
    @SequenceGenerator(
            name = "rent_car_sequence",
            sequenceName = "rent_car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rent_car_sequence")
    private Integer id;

    @Column(nullable = false)
    String renterName;

    @Column(nullable = false)
    Integer renterAge;

    @Column(nullable = false)
    String carModel;

    @Column(nullable = false)
    LocalDate startDate;

    @Column(nullable = false)
    LocalDate endDate;

    public RentCar() {
    }

    public RentCar(String renterName, Integer renterAge, String carModel, LocalDate startDate, LocalDate endDate) {
        this.renterName = renterName;
        this.renterAge = renterAge;
        this.carModel = carModel;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public RentCar(Integer id, String renterName, Integer renterAge, String carModel, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.renterName = renterName;
        this.renterAge = renterAge;
        this.carModel = carModel;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public Integer getRenterAge() {
        return renterAge;
    }

    public void setRenterAge(Integer renterAge) {
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

    @Override
    public String toString() {
        return "RentCar{" +
                "id=" + id +
                ", renterName='" + renterName + '\'' +
                ", renterAge=" + renterAge +
                ", carModel='" + carModel + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
