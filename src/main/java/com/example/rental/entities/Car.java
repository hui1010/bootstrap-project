package com.example.rental.entities;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "car")
public class Car {
    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "car_sequence")
    private Integer id;

    @Column(nullable = false)
    String model;
    @Column(nullable = false)
    Integer price;

    public Car() {
    }

    public Car(Integer id, String model, Integer price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    public Car(String model, Integer price) {
        this.model = model;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return getId().equals(car.getId()) && getModel().equals(car.getModel()) && getPrice().equals(car.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getPrice());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
