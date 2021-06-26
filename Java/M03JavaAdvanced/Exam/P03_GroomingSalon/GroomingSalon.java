package P03_GroomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public List<Pet> getData() {
        return data;
    }

    public void setData(List<Pet> data) {
        this.data = data;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream().filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        //o	" The grooming salon has the following clients:
        output.append(" The grooming salon has the following clients:");
        this
                .data
                .forEach(pet -> output
                        .append(System.lineSeparator())
                        .append(pet.getName())
                        .append(" ")
                        .append(pet.getOwner()));

        return output.toString();
    }
}
