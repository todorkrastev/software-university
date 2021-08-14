package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.List;

public class MissionImpl implements Mission{
    @Override
    public void explore(Planet planet, List<Astronaut> astronauts) {
        for (int astronaut = 0; astronaut < astronauts.size(); astronaut++) {
            Astronaut currAstronaut = astronauts.get(astronaut);
            for (int item = 0; item < planet.getItems().size(); item++) {
                String currItem = planet.getItems().get(item);
                currAstronaut.getBag().getItems().add(currItem);
                currAstronaut.breath();
                planet.getItems().remove(currItem);
                item--;
                if (!currAstronaut.canBreath()) {
                    astronauts.remove(currAstronaut);
                    astronaut--;
                    break;
                }
            }
        }
    }
}
