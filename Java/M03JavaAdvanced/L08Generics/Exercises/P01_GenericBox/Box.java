package bg.softuni.java_advanced.generics.exercises.P01_GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (T element : elements) {
            stringBuilder.append(String.format("%s: %s", element.getClass().getName(), element))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
