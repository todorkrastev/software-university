package bg.softuni.java_advanced.defining_classes.exercises.P04_RawDataSecondOption;

public class Car {
    private final String model;
    private final int enginePower;
    private final String cargoType;
    private final double firstTyre;
    private final double secondTyre;
    private final double thirdTyre;
    private final double fourthTyre;

    Car(String model, int enginePower, String cargoType, double firstTyre, double secondTyre, double thirdTyre, double fourthTyre) {
        this.model = model;
        this.enginePower = enginePower;
        this.cargoType = cargoType;
        this.firstTyre = firstTyre;
        this.secondTyre = secondTyre;
        this.thirdTyre = thirdTyre;
        this.fourthTyre = fourthTyre;
    }

    Boolean tirePressure() {
        return getFirstTyre() < 1 || getSecondTyre() < 1 || getThirdTyre() < 1 || getFourthTyre() < 1;
    }

    @Override
    public String toString() {
        return String.format("%s", getModel());
    }

    String getModel() {
        return model;
    }

    String getCargoType() {
        return cargoType;
    }

    int getEnginePower() {
        return enginePower;
    }

    double getFirstTyre() {
        return firstTyre;
    }

    double getSecondTyre() {
        return secondTyre;
    }

    double getThirdTyre() {
        return thirdTyre;
    }

    double getFourthTyre() {
        return fourthTyre;
    }
}

