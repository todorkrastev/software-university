package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
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
    private static int countExploredPlanets;

    public ControllerImpl() {
        this.setAstronautRepository();
        this.setPlanetRepository();
    }

    private void setAstronautRepository() {
        this.astronautRepository = new AstronautRepository();
    }

    private void setPlanetRepository() {
        this.planetRepository = new PlanetRepository();
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
        this.astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        List<String> listOfItems = Arrays.asList(items);
        Planet planet = new PlanetImpl(planetName);
        planet.getItems().addAll(listOfItems);
        this.planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        if (this.astronautRepository.getModels().stream().noneMatch(astronaut -> astronaut.getName().equals(astronautName))) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        Astronaut astronautByGivenName = this.astronautRepository.findByName(astronautName);
        this.astronautRepository.remove(astronautByGivenName);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        List<Astronaut> filteredAstronautsWithOxygenOverSixtyUnits = this.astronautRepository.getModels().stream().filter(astronaut -> astronaut.getOxygen() > 60).collect(Collectors.toList());
        if (filteredAstronautsWithOxygenOverSixtyUnits.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Planet planetByGivenName = this.planetRepository.findByName(planetName);
        Mission mission = new MissionImpl();
        int astronautsBeforeMission = filteredAstronautsWithOxygenOverSixtyUnits.size();
        mission.explore(planetByGivenName, filteredAstronautsWithOxygenOverSixtyUnits);
        int astronautsAfterMission = filteredAstronautsWithOxygenOverSixtyUnits.size();
        int deadAstronauts = astronautsBeforeMission - astronautsAfterMission;
        countExploredPlanets++;
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder output = new StringBuilder();
        output
                .append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, countExploredPlanets))
                .append(System.lineSeparator())
                .append(ConstantMessages.REPORT_ASTRONAUT_INFO)
                .append(System.lineSeparator());
        this.astronautRepository.getModels().forEach(astronaut -> {
            output
                    .append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, astronaut.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen()))
                    .append(System.lineSeparator());
            if (astronaut.getBag().getItems().isEmpty()) {
                output
                        .append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, "none"))
                        .append(System.lineSeparator());
            } else {
                output
                        .append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems()).replace("[", "").replace("]", "")))
                        .append(System.lineSeparator());
            }
        });
        return output.toString().trim();
    }
}
