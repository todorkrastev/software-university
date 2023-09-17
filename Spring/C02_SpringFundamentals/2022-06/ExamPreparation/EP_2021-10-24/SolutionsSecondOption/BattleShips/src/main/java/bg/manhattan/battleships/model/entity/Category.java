package bg.manhattan.battleships.model.entity;

import bg.manhattan.battleships.model.entity.enums.CategoryNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, unique = true)
    private CategoryNameEnum name;

    @Column(columnDefinition = "TEXT")
    private String Description;

    public CategoryNameEnum getName() {
        return name;
    }

    public Category setName(CategoryNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public Category setDescription(String description) {
        Description = description;
        return this;
    }
}
