package bg.softuni.java_oop.working_with_abstraction.lab.P02_PointInRectangle;

public class Rectangle {
    private final Point bottomLeft;
    private final Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        return this.bottomLeft.isGreaterOrEqual(point) && this.topRight.isLessOrEqual(point);
    }
}
