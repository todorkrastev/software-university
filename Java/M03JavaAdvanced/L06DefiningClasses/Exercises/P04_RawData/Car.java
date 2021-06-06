package bg.softuni.java_advanced.defining_classes.exercises.P04_RawData;

import java.util.Arrays;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyre[] tyres;

    public Car(String model, Engine engine, Cargo cargo, Tyre[] tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getModel() {
        return model;
    }

    public boolean hasTyreWithLessPressureThanOne() {
        for (Tyre tyre : tyres) {
            if (tyre.getTyrePressure() < 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
