package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;

public class PlanetRepository implements Repository<Planet> {
    private Collection<Planet> planets;

    public PlanetRepository() {
        this.setPlanets();
    }

    private void setPlanets() {
        this.planets = new ArrayList<>();
    }

    @Override
    public Collection<Planet> getModels() {
        //TODO: if it does not work try with Collections.unmodifiableList();
        return this.planets;
    }

    @Override
    public void add(Planet model) {
        //TODO: if getModels is unmodifiable MUST getModels be switched with astronauts;
        this.getModels().add(model);
    }

    @Override
    public boolean remove(Planet model) {
        //TODO: if getModels is unmodifiable MUST getModels be switched with astronauts;
        return this.planets.remove(model);
    }

    @Override
    public Planet findByName(String name) {
        //TODO: if getModels is unmodifiable MUST getModels be switched with astronauts;
        return this.planets.stream().filter(planet -> planet.getName().equals(name)).findFirst().orElse(null);
    }
}
