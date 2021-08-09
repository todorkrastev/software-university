package aquarium.entities.decorations;

public abstract class BaseDecoration implements Decoration {
    private int comfort;
    private double price;

    protected BaseDecoration(int comfort, double price) {
        this.setComfort(comfort);
        this.setPrice(price);
    }

    private void setComfort(int comfort) {
        this.comfort = comfort;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getComfort() {
        return this.comfort;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
