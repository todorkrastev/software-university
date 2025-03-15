package craftsmanLab.core;

import craftsmanLab.models.ApartmentRenovation;
import craftsmanLab.models.Craftsman;

import java.util.Collection;

public interface CraftsmanLab {
    void addApartment(ApartmentRenovation job);
    void addCraftsman(Craftsman craftsman);

    boolean exists(ApartmentRenovation job);
    boolean exists(Craftsman craftsman);

    void removeCraftsman(Craftsman craftsman);

    Collection<Craftsman> getAllCraftsmen();

    void assignRenovations();

    Craftsman getContractor(ApartmentRenovation job);

    Craftsman getLeastProfitable();

    Collection<ApartmentRenovation> getApartmentsByRenovationCost();

    Collection<ApartmentRenovation> getMostUrgentRenovations(int limit);
}
