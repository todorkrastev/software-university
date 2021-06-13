package bg.softuni.java_advanced.generics.exercises.P11_Threeuple;

public class Threeuple<K, V, V1> {

    K kay;
    V value;
    V1 values;

    public Threeuple(K kay, V value, V1 values) {
        this.kay = kay;
        this.value = value;
        this.values = values;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.kay, this.value, this.values).trim();
    }
}
