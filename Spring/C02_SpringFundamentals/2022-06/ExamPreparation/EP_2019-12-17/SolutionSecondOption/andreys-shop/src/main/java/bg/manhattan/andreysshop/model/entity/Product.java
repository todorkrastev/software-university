package bg.manhattan.andreysshop.model.entity;

import bg.manhattan.andreysshop.model.entity.enums.Category;
import bg.manhattan.andreysshop.model.entity.enums.Sex;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="products")
public class Product extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sex sex;

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Sex getSex() {
        return sex;
    }

    public Product setSex(Sex sex) {
        this.sex = sex;
        return this;
    }
}
