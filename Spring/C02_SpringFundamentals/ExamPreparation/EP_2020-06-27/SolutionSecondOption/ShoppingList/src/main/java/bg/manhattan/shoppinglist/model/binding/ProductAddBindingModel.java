package bg.manhattan.shoppinglist.model.binding;

import bg.manhattan.shoppinglist.model.entity.Category;
import bg.manhattan.shoppinglist.model.entity.enums.CategoryNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    /**
     * Has a Name (unique)
     * Name length must be between 3 and 20 characters (inclusive 3 and 20).
     */
    @NotNull(message = "Name length must be between 3 and 20 characters")
    @Size(min = 3, max = 20, message = "Name length must be between 3 and 20 characters")
    private String name;

    /**
     * Has a Description
     * Description min length must be minimum 5(inclusive) characters
     */
    @NotNull(message = "Description must be more than 5 characters!")
    @Size(min = 5, message = "Description must be more than 5 characters!")
    private String description;

    /**
     * Has a Price
     * The price must be a positive number
     */
    @NotNull(message = "The price must be a positive number!")
    @Positive(message = "The price must be a positive number!")
    private BigDecimal price;

    /**
     * Date and Time, that cannot be in the past
     */
    @FutureOrPresent(message = "Date cannot be in the past!")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime neededBefore;

    @NotNull(message = "Category cannot be null!")
    private CategoryNameEnum category;

    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
