package bg.softuni.java_advanced.preparation_exam_28_June_2020.P03_Parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(car -> (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)));
    }

    public Car getLatestCar() {
        return this.data.stream().min((p1, p2) -> Integer.compare(p2.getYear(), p1.getYear())).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return this.data.stream().filter(e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("The cars are parked in ");
        output.append(getType()).append(":").append(System.lineSeparator());
        data.forEach(e -> output.append(e).append(System.lineSeparator()));
        return output.toString();
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Car> getData() {
        return data;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }
}