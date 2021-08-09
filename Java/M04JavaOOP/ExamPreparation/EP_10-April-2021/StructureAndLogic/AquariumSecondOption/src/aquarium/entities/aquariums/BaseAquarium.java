package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ExceptionMessages.*;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.setDecorations();
        this.setFish();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setDecorations() {
        this.decorations = new ArrayList<>();
    }

    private void setFish() {
        this.fish = new ArrayList<>();
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.capacity <= this.fish.size()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.getFish().remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.getDecorations().add(decoration);
    }

    @Override
    public void feed() {
        this.getFish().forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        return (this.getFish().isEmpty()
                ? "none"
                : String.format("Fish: %s",
                this.getFish().stream().map(Fish::getName).collect(Collectors.joining(" ")))) +
                System.lineSeparator() +
                "Decorations: " + this.getDecorations().size() +
                System.lineSeparator() +
                "Comfort: " +
                this.calculateComfort();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
