package bg.softuni.java_oop.interfaces_and_abstraction.lab.P02_CarShopExtended;

public class Seat extends CarImpl implements Sellable {
    private final Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
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
