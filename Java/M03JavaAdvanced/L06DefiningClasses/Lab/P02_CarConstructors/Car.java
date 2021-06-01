package bg.softuni.java_advanced.defining_classes.lab.P02_CarConstructors;

public class Car {
    private static String defaultModel;
    private static int defaultHorsepower;
    private final String brand;
    private final String model;
    private final int horsepower;

    public Car(String brand) {
        this(brand, defaultModel, defaultHorsepower);
    }

    public Car(String brand, String model, int horsepower) {
        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;
    }

    public static void setDefaultModel(String defaultModel) {
        Car.defaultModel = defaultModel;
    }

    public static void setDefaultHorsepower(int defaultHorsepower) {
        Car.defaultHorsepower = defaultHorsepower;
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