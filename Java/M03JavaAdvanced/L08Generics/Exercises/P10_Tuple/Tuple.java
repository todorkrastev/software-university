package bg.softuni.java_advanced.generics.exercises.P10_Tuple;

public class Tuple<K, V> {

    K key;
    V value;

    public Tuple(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.key, this.value).trim();
    }
}
