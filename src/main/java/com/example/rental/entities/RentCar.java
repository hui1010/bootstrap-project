package com.example.rental.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "rentCar")
public class RentCar {
    @Id
    @SequenceGenerator(
            name = "rent_car_sequence",
            sequenceName = "rent_car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "rent_car_sequence")
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

    @Column(nullable = false)
    Integer cost;

    public RentCar() {
    }


    public RentCar(Integer id, String renterName, Integer renterAge, String carModel, LocalDate startDate, LocalDate endDate, Integer cost) {
        this.id = id;
        this.renterName = renterName;
        this.renterAge = renterAge;
        this.carModel = carModel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public RentCar(String renterName, Integer renterAge, String carModel, LocalDate startDate, LocalDate endDate, Integer cost) {
        this.renterName = renterName;
        this.renterAge = renterAge;
        this.carModel = carModel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentCar rentCar)) return false;
        return getId().equals(rentCar.getId()) && getRenterName().equals(rentCar.getRenterName()) && getRenterAge().equals(rentCar.getRenterAge()) && getCarModel().equals(rentCar.getCarModel()) && getStartDate().equals(rentCar.getStartDate()) && getEndDate().equals(rentCar.getEndDate()) && getCost().equals(rentCar.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRenterName(), getRenterAge(), getCarModel(), getStartDate(), getEndDate(), getCost());
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
                ", cost=" + cost +
                '}';
    }
}
