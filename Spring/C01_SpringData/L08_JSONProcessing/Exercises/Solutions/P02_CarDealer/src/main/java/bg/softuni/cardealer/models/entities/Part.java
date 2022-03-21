package bg.softuni.cardealer.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "parts")
public class Part extends BaseEntity{
    private String name;
    private BigDecimal price;
    private Long quantity;

    private Supplier supplier;
    private Set<Car> cars;

    public Part() {
        this.cars = new HashSet<>();
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "quantity")
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @ManyToMany(mappedBy = "parts")
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return Objects.equals(name, part.name) && Objects.equals(price, part.price) && Objects.equals(quantity, part.quantity) && Objects.equals(supplier, part.supplier) && Objects.equals(cars, part.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity, supplier, cars);
    }
}
