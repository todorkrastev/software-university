package bg.manhattan.coffeeshop.model.entity;

import bg.manhattan.coffeeshop.model.enums.CategoryName;

import javax.persistence.*;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private CategoryName name;

    @Column(name="needed_time", nullable = false)
    private Integer neededTime;

    public CategoryName getName() {
        return name;
    }

    public Category setName(CategoryName name) {
        this.name = name;
        return this;
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(Integer neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
