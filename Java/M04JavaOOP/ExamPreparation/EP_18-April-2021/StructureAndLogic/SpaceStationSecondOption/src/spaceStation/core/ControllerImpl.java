package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private Mission mission;
    private static int countExploredPlanets = 0;

    public ControllerImpl() {
        this.setAstronautRepository();
        this.setPlanetRepository();
        this.setMission();
    }

    private void setAstronautRepository() {
        this.astronautRepository = new AstronautRepository();
    }

    private void setPlanetRepository() {
        this.planetRepository = new PlanetRepository();
    }

    private void setMission() {
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        //TODO: if it does not work properly, try with getModels but it should be in MODIFIABLE MODE;
        this.astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        List<String> itemsToCollect = Arrays.asList(items);
        planet.getItems().addAll(itemsToCollect);
        this.planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronautByGivenName = this.astronautRepository.findByName(astronautName);
        if (astronautByGivenName == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        this.astronautRepository.remove(astronautByGivenName);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> astronautsWithOxygenMoreThanSixtyUnits = this.astronautRepository.getModels().stream().filter(astronaut -> astronaut.getOxygen() > 60).collect(Collectors.toList());
        Planet planetByName = this.planetRepository.findByName(planetName);
        int astronautsBeforeMission = astronautsWithOxygenMoreThanSixtyUnits.size();
        //TODO: if it does not work properly try to check if planetByName is null
        if (astronautsWithOxygenMoreThanSixtyUnits.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        this.mission.explore(planetByName, astronautsWithOxygenMoreThanSixtyUnits);
        countExploredPlanets++;
        int astronautsAfterMission = astronautsWithOxygenMoreThanSixtyUnits.size();
        int deadAstronauts = astronautsBeforeMission - astronautsAfterMission;

        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder output = new StringBuilder();
        output
                .append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, countExploredPlanets))
                .append(System.lineSeparator())
                .append(ConstantMessages.REPORT_ASTRONAUT_INFO);

        this.astronautRepository
                .getModels()
                .forEach(astronaut -> {
                    output
                            .append(System.lineSeparator())
                            .append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, astronaut.getName()))
                            .append(System.lineSeparator())
                            .append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen()));
                    if (astronaut.getBag().getItems().isEmpty()) {
                        output
                                .append(System.lineSeparator())
                                .append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none"));
                    } else {
                        output
                                .append(System.lineSeparator())
                                .append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS,
                                        astronaut.getBag().getItems()).replace("[", "").replace("]", ""));
                    }
                });
        return output.toString().trim();
    }
}
