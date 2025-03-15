package renovation.models;

public class Laminate {
    public double length;

    public double width;

    public WoodType woodType;

    public Laminate(double length, double width, WoodType woodType) {
        this.length = length;
        this.width = width;
        this.woodType = woodType;
    }

    public WoodType getWoodType() {
        return woodType;
    }

    @Override
    public String toString() {
        return "models.Laminate{" +
                "length=" + length +
                ", width=" + width +
                ", woodType='" + woodType + '\'' +
                '}';
    }
}
