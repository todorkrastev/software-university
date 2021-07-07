package bg.softuni.java_oop.interfaces_and_abstraction.lab.P02_CarShopExtended;

public interface Rentable extends Car {
    Integer getMinRentDay();

    Double getPricePerDay();
}
