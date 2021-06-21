package P03_RabbitsSecondOption;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private List<Rabbit> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Rabbit> getData() {
        return data;
    }

    public void setData(List<Rabbit> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(rabbit -> rabbit.getName().equals(name));
    }

    public List<Rabbit> removeSpecies(String species) {
        List<Rabbit> result = this.data.stream().filter(rabbit -> rabbit.getSpecies().equals(species)).collect(Collectors.toList());
        setData(this.data.stream().filter(rabbit -> !rabbit.getSpecies().equals(species)).collect(Collectors.toList()));
        return result;
    }

  /*  public void removeSpecies(String species) {
        this.data = this.data.stream().filter(rabbit -> !rabbit.getSpecies().equals(species)).collect(Collectors.toList());
    } */

    public Rabbit sellRabbit(String name) {
        this.data.stream().filter(rabbit -> rabbit.getName().equals(name)).findFirst().ifPresent(rabbit -> rabbit.setAvailable(false));
        return this.data.stream().filter(rabbit -> rabbit.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        return this.data.stream().filter(rabbit -> rabbit.getSpecies().equals(species)).collect(Collectors.toList());
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append("Rabbits available at ").append(this.getName()).append(":");
        data
                .forEach(rabbit -> output.append(System.lineSeparator()).append(rabbit));
        return output.toString();
    }
}
