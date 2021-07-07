package bg.softuni.java_oop.interfaces_and_abstraction.lab.P02_CarShopExtended;

public class Seat implements Car, Sellable {
    private final String model;
    private final String color;
    private final Integer horsePower;
    private final String countryProduced;
    private final Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.price = price;
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
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("%s sells for %f", this.getModel(), this.getPrice());
    }
}
