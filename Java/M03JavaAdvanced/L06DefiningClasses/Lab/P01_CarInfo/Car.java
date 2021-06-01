package bg.softuni.java_advanced.defining_classes.lab.P01_CarInfo;

public class Car {
    private final String brand;
    private final String model;
    private final int horsepower;

    public Car(String brand, String model, int horsepower) {
        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", getBrand(), getModel(), getHorsepower());
    }
}