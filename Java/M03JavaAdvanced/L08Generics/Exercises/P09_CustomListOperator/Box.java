package bg.softuni.java_advanced.generics.exercises.P09_CustomListOperator;

import java.util.*;

public class Box<T extends Comparable<T>> implements Iterable<T> {

    private final List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }

    public void printData() {
        this.data.forEach(System.out::println);
    }


    public long countGreaterThan(T element) {
        return this.data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public void swap(int first, int second) {
        Collections.swap(this.data, first, second);
    }

    public T getMax() {
        return this.data.stream().max(Comparator.naturalOrder()).orElse(null);
    }

    public T getMin() {
        return this.data.stream().min(Comparator.naturalOrder()).orElse(null);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public int size() {
        return this.data.size();
    }

    public T get(int index) {
        return this.data.get(index);
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public T next() {
                T element = data.get(index);
                index++;
                return element;
            }
        };
    }
}