package bg.manhattan.heroes.model.binding;

import bg.manhattan.heroes.model.entity.enums.HeroClass;
import bg.manhattan.heroes.model.validator.UniqueHeroName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class HeroBindingModel {
    @NotBlank(message = "Name is required!")
    @UniqueHeroName()
    private String name;

    @NotNull(message = "Hero class must be not null!")
    private HeroClass heroClass;

    @NotNull(message = "Level is required!")
    @Positive(message = "Level must be a positive number!")
    private Integer level;

    public String getName() {
        return name;
    }

    public HeroBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public HeroBindingModel setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public HeroBindingModel setLevel(Integer level) {
        this.level = level;
        return this;
    }
}
