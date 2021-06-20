package P03_ParkingSecondOption;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    //•	type: String
    //•	capacity: int
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public boolean remove(String manufacturer, String model) {
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
        StringBuilder output = new StringBuilder();
        output.append("The cars are parked in ")
                .append(this.getType())
                .append(":");
        this.data
                .forEach(car -> output.append(System.lineSeparator()).append(car));
        return output.toString();
    }
}
