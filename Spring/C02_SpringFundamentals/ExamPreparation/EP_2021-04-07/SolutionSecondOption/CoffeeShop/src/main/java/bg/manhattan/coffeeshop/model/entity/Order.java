package bg.manhattan.coffeeshop.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
public class Order extends BaseEntity{
    /**
     * The length of the name must be between 3 and 20 characters (both numbers are INCLUSIVE).
     */

    @Column(nullable = false,length = 21)
    private String name;

    /**
     * The price must be a positive number
     */
    @Column(nullable = false)
    private BigDecimal price;

    /**
     * The date and time that cannot be in the future
     */
    @Column(nullable = false, name = "order_time")
    private LocalDateTime orderTime;

    /**
     * The length of the description must be at least 5 (INCLUSIVE) characters
     * The description is a long text field.
     */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User employee;

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Order setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public Order setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Order setDescription(String description) {
        this.description = description;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Order setCategory(Category category) {
        this.category = category;
        return this;
    }

    public User getEmployee() {
        return employee;
    }

    public Order setEmployee(User employee) {
        this.employee = employee;
        return this;
    }
}
