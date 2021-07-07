package bg.softuni.java_oop.interfaces_and_abstraction.lab.P02_CarShopExtended;


public abstract class CarImpl implements Car {
    private final String model;
    private final String color;
    private final Integer horsePower;
    private final String countryProduced;

    public CarImpl(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    public String getCountryProduced() {
        return this.countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %s tires", this.getModel(), this.getCountryProduced(), Car.TYRES);
    }
}
