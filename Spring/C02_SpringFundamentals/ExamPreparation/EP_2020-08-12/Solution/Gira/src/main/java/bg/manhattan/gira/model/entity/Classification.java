package bg.manhattan.gira.model.entity;


import bg.manhattan.gira.model.entity.enums.ClassificationNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private ClassificationNameEnum name;

    @Column(columnDefinition = "TEXT")
    private String Description;

    public ClassificationNameEnum getName() {
        return name;
    }

    public Classification setName(ClassificationNameEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public Classification setDescription(String description) {
        Description = description;
        return this;
    }
}
