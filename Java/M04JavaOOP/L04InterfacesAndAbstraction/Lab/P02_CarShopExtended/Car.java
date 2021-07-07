package bg.softuni.java_oop.interfaces_and_abstraction.lab.P02_CarShopExtended;

public interface Car {
    Integer TYRES = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();
}
