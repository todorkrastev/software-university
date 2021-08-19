package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;

public abstract class RepositoryImpl<T> implements Repository<T>{
    private Collection<T> models;

    protected RepositoryImpl() {
        this.setModels();
    }

    private void setModels() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<T> getModels() {
        return this.models;
    }

    @Override
    public abstract void add(T model);

    @Override
    public boolean remove(T model) {
        return this.getModels().remove(model);
    }

    @Override
    public abstract T findByName(String name);
}
