package restaurant.repositories;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.repositories.interfaces.BeverageRepository;

public class BeverageRepositoryImpl extends RepositoryImpl<Beverages> implements BeverageRepository<Beverages> {
    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return super.getAllEntities().stream()
                .filter(d -> d.getName().equals(drinkName) && d.getBrand().equals(drinkBrand))
                .findFirst()
                .orElse(null);
    }
}
