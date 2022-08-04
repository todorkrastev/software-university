package bg.manhattan.heroes.service;

import bg.manhattan.heroes.model.service.HeroServiceModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HeroService {
    Optional<HeroServiceModel> getHeroByHeroName(String heroName);

    void create(HeroServiceModel map);

    List<HeroServiceModel> getAllHeroesByLevelDesc();

    void deleteById(UUID id);

    Optional<HeroServiceModel> getById(UUID id);
}
