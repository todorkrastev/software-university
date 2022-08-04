package bg.manhattan.heroes.model.binding;

import bg.manhattan.heroes.model.entity.enums.HeroClass;
import bg.manhattan.heroes.model.validator.UniqueHeroName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

public class HeroDeleteBindingModel {

    private UUID id;

    @NotBlank(message = "Name is required!")
    @UniqueHeroName()
    private String name;

    @NotNull(message = "Hero class must be not null!")
    private HeroClass heroClass;

    @NotNull(message = "Level is required!")
    @Positive(message = "Level must be a positive number!")
    private Integer level;

    public UUID getId() {
        return id;
    }

    public HeroDeleteBindingModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HeroDeleteBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public HeroDeleteBindingModel setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public HeroDeleteBindingModel setLevel(Integer level) {
        this.level = level;
        return this;
    }
}
