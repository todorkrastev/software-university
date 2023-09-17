package bg.manhattan.andreysshop.model.binding;

import bg.manhattan.andreysshop.model.entity.enums.Category;
import bg.manhattan.andreysshop.model.entity.enums.Sex;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class ProductAddBindingModel {
    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Description name is required")
    private String description;

    @NotNull(message = "Price name is required")
    @Positive(message = "Price must be positive number")
    private BigDecimal price;

    @NotNull(message = "You have to select a category")
    private Category category;

    @NotNull(message = "You have to select a sex")
    private Sex sex;

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

    public Category getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Sex getSex() {
        return sex;
    }

    public ProductAddBindingModel setSex(Sex sex) {
        this.sex = sex;
        return this;
    }
}
