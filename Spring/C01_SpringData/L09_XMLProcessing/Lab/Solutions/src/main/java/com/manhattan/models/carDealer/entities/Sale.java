package com.manhattan.models.carDealer.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name="discount_percentage")
    private BigDecimal discountPercentage;

    public Customer getCustomer() {
        return customer;
    }

    public Sale() {
    }

    public Sale(Car car, Customer customer, BigDecimal discountPercentage) {
        this.car = car;
        this.customer = customer;
        this.discountPercentage = discountPercentage;
    }

    public Car getCar() {
        return car;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
