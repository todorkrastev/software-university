package bg.softuni.java_advanced.generics.exercises.P08_CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private final List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T dataType) {
        this.list.add(dataType);
    }

    public T remove(int index) {
        if (!isInBounds(index)) {
            throw new IndexOutOfBoundsException("Please, insert valid index.");
        }
        return this.list.remove(index);
    }

    public boolean contains(T dataType) {
        return this.list.contains(dataType);
    }

    public void swap(int firstIndex, int secondIndex) {
        if (isInBounds(firstIndex, secondIndex)) {
            Collections.swap(this.list, firstIndex, secondIndex);
        } else {
            throw new IndexOutOfBoundsException("Please, insert valid index/indexes.");
        }
    }

    public long countGreaterThan(T dataType) {
        return this.list
                .stream()
                .filter(e -> e.compareTo(dataType) > 0)
                .count();
    }

    public T getMax() {
        return Collections.max(this.list);
    }

    public T getMin() {
        return Collections.min(this.list);
    }

    public void sort() {
        Collections.sort(this.list);
    }

    private boolean isInBounds(int firstIndex, int secondIndex) {
        return 0 <= firstIndex && firstIndex < this.list.size() && 0 <= secondIndex && secondIndex < this.list.size();
    }

    private boolean isInBounds(int index) {
        return 0 <= index && index < this.list.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (T element : list) {
            stringBuilder.append(element)
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
