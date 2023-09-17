package bg.manhattan.heroes.model.view;

import bg.manhattan.heroes.model.entity.enums.HeroClass;

public class HeroDetailsViewModel {
    private String name;
    private HeroClass heroClass;
    private Integer level;

    public String getName() {
        return name;
    }

    public HeroDetailsViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public HeroDetailsViewModel setHeroClass(HeroClass heroClass) {
        this.heroClass = heroClass;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public HeroDetailsViewModel setLevel(Integer level) {
        this.level = level;
        return this;
    }
}
