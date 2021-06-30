package bg.softuni.java_oop.working_with_abstraction.lab.P04_HotelReservation;

public class PriceCalculator {
    private final double pricePerDay;
    private final int days;
    private final Season season;
    private final Discount discount;

    public PriceCalculator(double pricePerDay, int days, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.season = season;
        this.discount = discount;
    }

    public double calculatePrice() {
        return (pricePerDay * season.getMultiplier()) * days * (1 - discount.getPercentage());
    }
}
