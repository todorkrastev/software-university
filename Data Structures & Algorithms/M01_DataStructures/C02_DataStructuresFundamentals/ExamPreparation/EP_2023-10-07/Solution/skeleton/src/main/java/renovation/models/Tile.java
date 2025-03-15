package renovation.models;

public class Tile {
    public double width;
    public double height;
    public double depth;

    public Tile() {
    }

    public Tile(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "models.Tile{" +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }
}
