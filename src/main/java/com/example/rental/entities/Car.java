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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_sequence")
    private Integer id;

    @Column(nullable = false)
    String modal;
    @Column(nullable = false)
    Integer price;

    public Car() {
    }

    public Car(Integer id, String modal, Integer price) {
        this.id = id;
        this.modal = modal;
        this.price = price;
    }

    public Car(String modal, Integer price) {
        this.modal = modal;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
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
        return getId().equals(car.getId()) && getModal().equals(car.getModal()) && getPrice().equals(car.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModal(), getPrice());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", modal='" + modal + '\'' +
                ", price=" + price +
                '}';
    }
}
