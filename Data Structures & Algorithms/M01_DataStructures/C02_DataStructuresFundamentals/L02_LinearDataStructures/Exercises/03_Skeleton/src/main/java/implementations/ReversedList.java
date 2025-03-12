package implementations;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class ReversedList<E> implements Iterable<E> {
    public static final int INITIAL_SIZE = 2;
    private Object[] elements;
    private int size;

    public ReversedList() {
        this.elements = new Object[INITIAL_SIZE];
        size = 0;
    }

    public ReversedList(Object[] elements) {
        this.elements = elements;
        size = this.elements.length;
    }

    public void add(E element) {
        if (capacityReached()) {
            this.elements = grow();
        }
        elements[this.size++] = element;
    }

    private boolean capacityReached() {
        return this.size == this.capacity();
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        this.checkIndex(index);
        return (E) this.elements[this.size - index - 1];
    }

    public void removeAt(int index) {
        this.checkIndex(index);
        elements[index] = null;
        if (size >= 0) {
            System.arraycopy(elements, index + 1, elements, index, size - index);
        }
        this.size--;
        ensureCapacity();
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.elements.length;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = size - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public E next() {
                return (E) elements[index--];
            }
        };
    }

    private Object[] grow() {
        return Arrays.copyOf(this.elements, this.elements.length * 2);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException(
                    String.format("Index out of bounds: %d for size: %d", index, this.size)
            );
        }
    }

    private void ensureCapacity() {
        if (this.size < this.elements.length / 3) {
            this.elements = shrink();
        }
    }

    private Object[] shrink() {
        return Arrays.copyOf(this.elements, this.elements.length / 2);
    }

    @Override
    public String toString() {
        return Arrays.stream(this.elements)
                .map(x -> x == null ? "_" : x.toString())
                .collect(Collectors.joining(" "));
    }
}