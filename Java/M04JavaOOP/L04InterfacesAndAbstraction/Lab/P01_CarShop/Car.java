package bg.softuni.java_oop.interfaces_and_abstraction.lab.P01_CarShop;

public interface Car {
    Integer TYRES = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();
}
