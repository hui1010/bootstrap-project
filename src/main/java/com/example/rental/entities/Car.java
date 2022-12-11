package com.example.rental.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
    @Id
    String carModel;

    Float price;

    public Car(String carModel, Float price) {
        this.carModel = carModel;
        this.price = price;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModal(String carModel) {
        this.carModel = carModel;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
