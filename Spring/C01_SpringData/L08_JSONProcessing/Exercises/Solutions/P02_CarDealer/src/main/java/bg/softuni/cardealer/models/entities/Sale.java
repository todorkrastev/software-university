package bg.softuni.cardealer.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {
    private BigDecimal discount;

    private Car car;
    private Customer customer;

    public Sale() {
    }

    public Sale(BigDecimal discount, Car car, Customer customer) {
        this.discount = discount;
        this.car = car;
        this.customer = customer;
    }

    @Column(name = "discount")
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @ManyToOne
    @JoinColumn(name = "car_id")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
