package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.List;

public interface Mission {
    void explore(Planet planet, List<Astronaut> astronauts);
}
