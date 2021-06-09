package bg.softuni.java_advanced.defining_classes.exercises.P07_Google;

public class Car {
    private final String carModel;
    private final int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return carModel + " " + carSpeed;
    }
}
