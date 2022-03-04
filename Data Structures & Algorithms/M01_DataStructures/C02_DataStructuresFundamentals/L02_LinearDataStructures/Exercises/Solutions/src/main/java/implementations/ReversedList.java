package implementations;

import interfaces.ListReversed;

import java.util.Iterator;

public class ReversedList<E> implements ListReversed<E> {
    private Object[] elements;
    private int size;

    public ReversedList() {
        int INITIAL_CAPACITY = 2;
        this.elements = new Object[INITIAL_CAPACITY];
    }


    @Override
    public void add(Object element) {
        if (this.size == this.elements.length) {
            this.elements = grow();
        }

        if (element != null) {
            this.elements[size] = element;
            size++;
        }
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public E get(int index) {
        if (indexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        int reversedIndex = getReversedIndex(index);
        return (E) this.elements[reversedIndex];
    }

    @Override
    public E removeAt(int index) {
        if (indexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
        int reversedIndex = getReversedIndex(index);
        Object element = this.elements[reversedIndex];
        shiftLeft(reversedIndex);
        size--;
        return (E) element;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int index = size - 1;

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
        int newCapacity = this.size * 2;
        Object[] tmp = new Object[newCapacity];

        for (int i = 0; i < this.elements.length; i++) {
            tmp[i] = this.elements[i];
        }

        return tmp;
    }

    private boolean indexOutOfBounds(int index) {
        return index < 0 || index > this.size - 1;
    }

    private int getReversedIndex(int index) {
        return (this.size - 1) - index;
    }
}
