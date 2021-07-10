package bg.softuni.java_oop.polymorphism.lab.P02_Shapes;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * Math.PI * getRadius();
    }

    public final Double getRadius() {
        return this.radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }
}
