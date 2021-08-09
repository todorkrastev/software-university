package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;


import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.setDecorations();
        this.setAquariums();
    }

    private void setDecorations() {
        this.decorations = new DecorationRepository();
    }

    private void setAquariums() {
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType) {
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default:
                throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type) {
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default:
                throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        this.decorations.add(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decorationByType = this.decorations.findByType(decorationType);

        if (decorationByType == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }

        Aquarium aquariumByGivenName = this.aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().orElse(null);

        if (aquariumByGivenName != null) {
            aquariumByGivenName.addDecoration(decorationByType);
        }

        this.decorations.remove(decorationByType);


        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        switch (fishType) {
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName, fishSpecies, price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName, fishSpecies, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }

        Aquarium aquariumByGivenName = this.aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().orElse(null);
        String output = null;
        if (aquariumByGivenName != null) {
            if (!aquariumByGivenName.getClass().getSimpleName().substring(0, 5).equals(fishType.substring(0, 5))) {
                output = WATER_NOT_SUITABLE;
            } else {
                aquariumByGivenName.addFish(fish);
                output = String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
            }
        }
        return output;
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquariumByGivenName = this.aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().orElse(null);
        if (aquariumByGivenName != null) {
            aquariumByGivenName.feed();
        }
        int fedFish = aquariumByGivenName != null ? aquariumByGivenName.getFish().size() : 0;
        return String.format(FISH_FED, fedFish);
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquariumByGivenName = this.aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().orElse(null);
        double totalSum = 0.0;
        if (aquariumByGivenName != null) {
            double sumOfFish = aquariumByGivenName.getFish().stream().mapToDouble(Fish::getPrice).sum();
            double sumOfDecorations = aquariumByGivenName.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
            totalSum = sumOfFish + sumOfDecorations;
        }
        return String.format(VALUE_AQUARIUM, aquariumName, totalSum);
    }

    @Override
    public String report() {
        StringBuilder output = new StringBuilder();

        this.aquariums.forEach(aquarium -> output
                .append(aquarium.getInfo())
                .append(System.lineSeparator()));

        return output.toString().trim();

    }
}
