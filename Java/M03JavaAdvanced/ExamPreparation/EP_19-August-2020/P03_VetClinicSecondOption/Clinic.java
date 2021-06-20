package P03_VetClinicSecondOption;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
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

    public Pet getOldestPet() {
        return this.data.stream().max((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())).orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append("The clinic has the following patients:");
        this.data
                .forEach(pet -> output.append(System.lineSeparator()).append(pet.getName()).append(" ").append(pet.getOwner()));
        return output.toString();
    }
}
