package storageService.models;

public class Box {
    public String id;
    public int width;
    public int height;
    public int depth;

    public Box(String id, int width, int height, int depth) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public String getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public int getVolume() {
        return width * height * depth;
    }
}
