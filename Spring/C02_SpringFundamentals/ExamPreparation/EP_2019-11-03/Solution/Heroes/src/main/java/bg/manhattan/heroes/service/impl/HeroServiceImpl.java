package bg.manhattan.heroes.service.impl;

import bg.manhattan.heroes.model.entity.Hero;
import bg.manhattan.heroes.model.service.HeroServiceModel;
import bg.manhattan.heroes.repository.HeroRepository;
import bg.manhattan.heroes.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HeroServiceImpl implements HeroService {
    private final HeroRepository repository;
    private final ModelMapper mapper;

    public HeroServiceImpl(HeroRepository repository,
                           ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<HeroServiceModel> getHeroByHeroName(String heroName) {
        Optional<Hero> dbHero = this.repository.findByName(heroName);
        return dbHero.map(hero -> this.mapper.map(hero, HeroServiceModel.class));
    }

    @Override
    public void create(HeroServiceModel heroModel) {
        Hero hero = this.mapper.map(heroModel, Hero.class);
        this.repository.save(hero);
    }

    @Override
    public List<HeroServiceModel> getAllHeroesByLevelDesc() {
        return this.repository.findAllByOrderByLevelDesc()
                .stream()
                .map(hero -> this.mapper.map(hero, HeroServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<HeroServiceModel> getById(UUID id) {
        Optional<Hero> hero = this.repository.findById(id);
        return hero.map(h -> this.mapper.map(h, HeroServiceModel.class));
    }
}
