package bg.manhattan.heroes.model.service;

import bg.manhattan.heroes.model.entity.enums.HeroClass;

import java.util.UUID;

public class HeroServiceModel {
    private UUID id;
    private String name;
    private HeroClass heroClass;
    private Integer level;

    public UUID getId() {
        return id;
    }

    public HeroServiceModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HeroServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public HeroServiceModel setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public HeroServiceModel setLevel(Integer level) {
        this.level = level;
        return this;
    }
}
