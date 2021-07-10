package bg.softuni.java_oop.polymorphism.lab.P02_Shapes;

public class Rectangle extends Shape {
    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return this.height;
    }

    public Double getWidth() {
        return this.width;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * (getHeight() + getWidth());
    }

    @Override
    public Double calculateArea() {
        return getHeight() * getWidth();
    }
}
