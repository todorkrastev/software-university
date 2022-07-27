package com.todorkrastev.andreysstore.model.binding;

import com.todorkrastev.andreysstore.model.entity.enums.CategoryName;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ItemAddBindingModel {

    private String name;
    private String description;
    private CategoryName category;
    private String gender;
    private BigDecimal price;

    public ItemAddBindingModel() {
    }

    @Length(min = 2, message = "Username length must at least 2 characters long!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 3, message = "Description length must at least 3 characters long!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Enter valid category!")
    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }

    @Length(min = 2, message = "Enter valid gender!")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @DecimalMin(value = "0", message = "Enter valid price!")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
