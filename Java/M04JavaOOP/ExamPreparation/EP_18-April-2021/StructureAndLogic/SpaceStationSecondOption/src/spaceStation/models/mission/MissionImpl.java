package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<Astronaut> astronautsWithOxygen = astronauts.stream().filter(Astronaut::canBreath).collect(Collectors.toList());
        List<String> itemsToCollect = new ArrayList<>(planet.getItems());

        for (Astronaut currAstronaut : astronautsWithOxygen) {
            for (int item = 0; item < itemsToCollect.size(); item++) {
                if (itemsToCollect.stream().iterator().hasNext()) {
                    String currItem = itemsToCollect.stream().iterator().next();
                    currAstronaut.getBag().getItems().add(currItem);
                    itemsToCollect.remove(item);
                    item--;
                    currAstronaut.breath();
                }
                if (!currAstronaut.canBreath()) {
                    astronauts.remove(currAstronaut);
                    break;
                }
            }
        }
    }
}
