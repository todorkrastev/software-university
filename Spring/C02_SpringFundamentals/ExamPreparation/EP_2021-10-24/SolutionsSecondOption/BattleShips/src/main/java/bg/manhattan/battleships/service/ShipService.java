package bg.manhattan.battleships.service;

import bg.manhattan.battleships.model.entity.Ship;
import bg.manhattan.battleships.model.service.ShipFireServiceModel;
import bg.manhattan.battleships.model.service.ShipServiceModel;
import bg.manhattan.battleships.model.view.ShipListViewModel;

import java.util.Optional;

public interface ShipService {
    void addShip(ShipServiceModel shipModel);

    ShipListViewModel getAllShips();

    void fire(ShipFireServiceModel fireModel);

    Optional<Ship> findByName(String shipName);
}
