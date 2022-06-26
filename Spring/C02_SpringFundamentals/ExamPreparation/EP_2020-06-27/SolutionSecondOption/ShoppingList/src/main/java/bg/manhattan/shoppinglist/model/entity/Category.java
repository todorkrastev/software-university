package bg.manhattan.shoppinglist.model.entity;

import bg.manhattan.shoppinglist.model.entity.enums.CategoryNameEnum;
import org.springframework.context.annotation.Description;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CategoryNameEnum name;

    @Column()
    private String Description;

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

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
