package bg.softuni.java_oop.working_with_abstraction.lab.P02_PointInRectangle;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    boolean isLessOrEqual(Point point) {
        return point.getX() <= this.x && point.getY() <= this.y;
    }

    public boolean isGreaterOrEqual(Point point) {
        return this.x <= point.getX() && this.y <= point.getY();
    }
}
