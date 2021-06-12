package bg.softuni.java_advanced.generics.exercises.P03_GenericSwapMethodStringsSecondOption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private final List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        if (isInBounds(firstIndex, secondIndex)) {
            Collections.swap(this.elements, firstIndex, secondIndex);
        } else {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    private boolean isInBounds(int firstIndex, int secondIndex) {
        return 0 <= firstIndex && firstIndex < this.elements.size() && 0 <= secondIndex && secondIndex < this.elements.size();
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

