package bg.softuni.java_oop.polymorphism.exercises.P03_WildFarm.foods;

public abstract class Food {
    private int quantity;

    protected Food(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
