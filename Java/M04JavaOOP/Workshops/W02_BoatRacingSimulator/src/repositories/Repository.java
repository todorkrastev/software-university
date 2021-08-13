package repositories;

import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;
import models.interfaces.ModelGetter;

public interface Repository<T extends ModelGetter> {
    void add(T entity) throws DuplicateModelException;
    T get(String model) throws NonExistantModelException;
}
