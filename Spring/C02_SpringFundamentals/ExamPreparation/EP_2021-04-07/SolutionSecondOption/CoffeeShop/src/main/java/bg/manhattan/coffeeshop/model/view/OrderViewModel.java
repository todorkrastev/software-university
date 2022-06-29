package bg.manhattan.coffeeshop.model.view;

import bg.manhattan.coffeeshop.model.entity.Category;
import bg.manhattan.coffeeshop.model.entity.User;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderViewModel {
    private long Id;
    private String name;
    private BigDecimal price;
    private LocalDateTime orderTime;
    private String category;

    private int prepareTime;

    public long getId() {
        return Id;
    }

    public OrderViewModel setId(long id) {
        Id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderViewModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public OrderViewModel setCategory(String category) {
        this.category = category;
        return this;
    }

    public int getPrepareTime() {
        return prepareTime;
    }

    public OrderViewModel setPrepareTime(int prepareTime) {
        this.prepareTime = prepareTime;
        return this;
    }
}
