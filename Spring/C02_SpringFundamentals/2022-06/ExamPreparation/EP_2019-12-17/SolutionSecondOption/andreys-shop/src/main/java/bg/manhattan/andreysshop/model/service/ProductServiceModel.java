package bg.manhattan.andreysshop.model.service;

import bg.manhattan.andreysshop.model.entity.enums.Category;
import bg.manhattan.andreysshop.model.entity.enums.Sex;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

public class ProductServiceModel {

    private String name;

    private String description;

    private BigDecimal price;

    private Category category;

    private Sex sex;

    public String getName() {
        return name;
    }

    public ProductServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public ProductServiceModel setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Sex getSex() {
        return sex;
    }

    public ProductServiceModel setSex(Sex sex) {
        this.sex = sex;
        return this;
    }
}
