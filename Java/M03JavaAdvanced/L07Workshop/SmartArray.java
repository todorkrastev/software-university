package bg.softuni.java_advanced.workshop;

import java.util.function.Consumer;

public class SmartArray {
    private int[] elements;
    private int size;

    public SmartArray() {
        this.elements = new int[8];
        this.size = 0;
    }

    public void add(int element) {
        if (this.elements.length == this.size) {
            int[] newElements = new int[this.size * 2];
            System.arraycopy(this.elements, 0, newElements,
                    0, this.elements.length);
            this.elements = newElements;
        }

        this.elements[this.size++] = element;
    }

    public int remove(int index) {
        int element = get(index);

        if (this.size - 1 - index >= 0) {
            System.arraycopy(this.elements, index + 1,
                    this.elements, index, this.size - 1 - index);
        }

        this.elements[--this.size] = 0;

        if (this.elements.length == this.size * 4 && this.size >= 8) {
            int[] newElements = new int[this.size];
            System.arraycopy(this.elements, 0, newElements, 0, this.size);
            this.elements = newElements;
        }

        if (this.isEmpty()) {
            this.elements = new int[8];
            this.size = 0;
        }

        return element;
    }

    public int get(int index) {
        validateIndex(index);
        return this.elements[index];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        validateIndex(index);

        int lastElement = this.elements[this.size - 1];

        if (this.size - 1 - index >= 0) {
            System.arraycopy(this.elements, index, this.elements,
                    index + 1, this.size - 1 - index);
        }

        this.elements[index] = element;

        add(lastElement);
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index +
                    " out of bounds for size " + this.size);
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            int element = this.elements[i];
            consumer.accept(element);
        }
    }
}
