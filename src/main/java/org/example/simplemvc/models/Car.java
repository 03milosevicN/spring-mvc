package org.example.simplemvc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer car_id;

    @Column(nullable = false)
    private Date year;

    @Column(nullable = false)
    @Size(min = 2, max = 4)
    private Integer horsepower;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    private String img_url;

    @ManyToMany
    @JoinTable(
            name="car_transaction",
            joinColumns = @JoinColumn(name="car_id"),
            inverseJoinColumns = @JoinColumn(name="transaction_id")
    )
    private List<Transactions> transactions;

    public Car() {}

    public Car(Integer car_id, Date year, Integer horsepower, String make, String model, String img_url) {
        this.car_id = car_id;
        this.year = year;
        this.horsepower = horsepower;
        this.make = make;
        this.model = model;
        this.img_url = img_url;
    }

    public Car(Date year, Integer horsepower, String make, String model) {
        this.year = year;
        this.horsepower = horsepower;
        this.make = make;
        this.model = model;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", year=" + year +
                ", horsepower=" + horsepower +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", img_url='" + img_url + '\'' +
                '}';
    }

}
