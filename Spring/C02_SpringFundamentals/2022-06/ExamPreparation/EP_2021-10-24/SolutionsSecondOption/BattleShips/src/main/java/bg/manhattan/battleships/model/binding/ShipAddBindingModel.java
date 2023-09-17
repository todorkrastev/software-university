package bg.manhattan.battleships.model.binding;

import bg.manhattan.battleships.model.entity.enums.CategoryNameEnum;
import bg.manhattan.battleships.model.validator.UniqueShipName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ShipAddBindingModel {

    /**
     * The length of the values must be between 2 and 10 characters (both numbers are INCLUSIVE)
     * The values should be unique in the database
     */
    @NotNull(message = "Name must be between 2 and 10 characters.")
    @Size(min=2, max = 10, message = "Name must be between 2 and 10 characters.")
    @UniqueShipName()
    private String name;

    /**
     * The values should be positive numbers
     */
    @NotNull(message = "The health is required" )
    @Positive(message = "The health must be positive.")
    private Long health;

    /**
     * The values should be positive numbers
     */
    @NotNull(message = "The power is required" )
    @Positive(message = "The power must be positive.")
    private Long power;

    /**
     * The values should not be future dates
     */
    @PastOrPresent(message = "Created date cannot be in the future.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @NotNull(message = "You must select the category.")
    private CategoryNameEnum category;

    public String getName() {
        return name;
    }

    public ShipAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipAddBindingModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipAddBindingModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipAddBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
