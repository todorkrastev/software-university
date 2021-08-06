package CounterStriker.repositories;

import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerRepository <T extends Player> implements Repository<T> {
    Collection<T> models;

    public PlayerRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getModels() {
        return this.models;
    }

    @Override
    public void add(T model) {
        models.add(model);
    }

    @Override
    public boolean remove(T model) {
        return models.remove(model);
    }

    @Override
    public T findByName(String name) {
        return this.models.stream().filter(m -> m.getUsername().equals(name)).findFirst().orElse(null);
    }
}
