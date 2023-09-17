package bg.manhattan.coffeeshop.model.binding;

import bg.manhattan.coffeeshop.model.entity.Category;
import bg.manhattan.coffeeshop.model.entity.User;
import bg.manhattan.coffeeshop.model.enums.CategoryName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {

    /**
     * The length of the name must be between 3 and 20 characters (both numbers are INCLUSIVE).
     */
    @NotNull
    @Size(min=3, max = 20)
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    /**
     * The date and time that cannot be in the future
     */
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderTime;

    /**
     * The length of the description must be at least 5 (INCLUSIVE) characters
     * The description is a long text field.
     */
    @Size(min = 5)
    private String description;

    @NotNull
    private CategoryName category;

    public String getName() {
        return name;
    }

    public OrderAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderAddBindingModel setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public OrderAddBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }
}
