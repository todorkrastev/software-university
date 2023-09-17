package bg.manhattan.battleships.model.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ShipListViewModel {
    private List<ShipViewModel> ownedShips;
    private List<ShipViewModel> othersShips;
    private List<ShipViewModel> allShips;

    public ShipListViewModel(List<ShipViewModel> allShips, String ownersName) {
        this.allShips = allShips;
        this.ownedShips = new ArrayList<>();
        this.othersShips = new ArrayList<>();
        allShips.stream()
                .forEach(s -> {
                    if (s.getOwnerName().equals(ownersName)) {
                        this.ownedShips.add(s);
                    } else {
                        this.othersShips.add(s);
                    }
                });
    }

    public List<ShipViewModel> getOwnedShips() {
        return Collections.unmodifiableList(ownedShips);
    }

    public List<ShipViewModel> getOthersShips() {
        return Collections.unmodifiableList(othersShips);
    }

    public List<ShipViewModel> getAllShips() {
        return Collections.unmodifiableList(allShips);
    }
}
