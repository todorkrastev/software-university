package bg.softuni.java_advanced.generics.exercises.P06_GenericCountMethodDoubles;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private final List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public long countGreaterThan(T elementToCompare) {
        return this.elements
                .stream()
                .filter((e) -> e.compareTo(elementToCompare) > 0)
                .count();
    }
}
