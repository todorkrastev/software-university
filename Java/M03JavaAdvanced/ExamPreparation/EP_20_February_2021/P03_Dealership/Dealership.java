package bg.softuni.java_advanced.exam_preparation_20_February_2021.P03_Dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
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

    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return this.data.removeIf(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model));
    }

    public Car getLatestCar() {
        return this.data.stream().max((c1, c2) -> Integer.compare(c1.getYear(), c2.getYear())).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        //o	" The cars are in a car dealership {name}:
        //{Car1}
        //{Car2}
        //(…)"
        StringBuilder output = new StringBuilder();
        output
                .append(" The cars are in a car dealership ")
                .append(this.getName())
                .append(":");
        this.data
                .forEach(car -> output.append(System.lineSeparator()).append(car));
        return output.toString();
    }
}
