package bg.manhattan.battleships.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity{

    /**
     * The length of the values must be between 2 and 10 characters (both numbers are INCLUSIVE)
     * The values should be unique in the database
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * The values should be positive numbers
     */
   @Column(nullable = false)
    private Long health;

    /**
     * The values should be positive numbers
     */
    @Column(nullable = false)
    private Long power;

    /**
     * The values should not be future dates
     */
    @Column(nullable = false)
    private LocalDate created;

    @ManyToOne(optional = false)
    private Category category;

    @ManyToOne(optional = false)
    private User user;

    public String getName() {
        return name;
    }

    public Ship setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public Ship setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public Ship setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Ship setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Ship setCategory(Category category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Ship setUser(User user) {
        this.user = user;
        return this;
    }
}
