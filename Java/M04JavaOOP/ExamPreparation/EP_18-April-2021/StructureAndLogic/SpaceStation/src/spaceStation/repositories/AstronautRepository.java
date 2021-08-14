package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AstronautRepository implements Repository<Astronaut> {
    private List<Astronaut> astronauts;

    public AstronautRepository() {
        this.setAstronauts();
    }

    private void setAstronauts() {
        this.astronauts = new ArrayList<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableList(this.astronauts);
    }

    @Override
    public void add(Astronaut model) {
        this.astronauts.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return this.astronauts.remove(model);
    }

    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.stream().filter(astronaut -> astronaut.getName().equals(name)).findFirst().orElse(null);
    }
}
