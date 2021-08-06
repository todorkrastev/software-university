package bakery.repositories;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.repositories.interfaces.FoodRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {

    private final Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {

        return this.models.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<BakedFood> getAll() {

        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(BakedFood bakedFood) {
        this.models.add(bakedFood);

    }
}