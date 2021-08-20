package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;

public class AstronautRepository implements Repository<Astronaut> {
    private Collection<Astronaut> astronauts;

    public AstronautRepository() {
        this.setAstronauts();
    }

    private void setAstronauts() {
        this.astronauts = new ArrayList<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        //TODO: if it does not work try with Collections.unmodifiableList();
        return this.astronauts;
    }

    @Override
    public void add(Astronaut model) {
        //TODO: if getModels is unmodifiable MUST getModels be switched with astronauts;
        this.getModels().add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        //TODO: if getModels is unmodifiable MUST getModels be switched with astronauts;
        return this.getModels().remove(model);
    }

    @Override
    public Astronaut findByName(String name) {
        //TODO: if getModels is unmodifiable MUST getModels be switched with astronauts;
        return this.getModels().stream().filter(astronaut -> astronaut.getName().equals(name)).findFirst().orElse(null);
    }
}
