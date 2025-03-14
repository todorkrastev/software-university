package implementations;

import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    List<E> elements = new ArrayList<>();

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(this.elements.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0 && isLessThan(getParentIndex(index), index)) {
            Collections.swap(this.elements, index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private boolean isLessThan(int parentIndex, int childIndex) {
        return getElement(parentIndex).compareTo(getElement(childIndex)) < 0;
    }

    @Override
    public E peek() {
        if (this.elements.isEmpty()) throw new IllegalStateException("Illegal call to peek on empty heap");
        return getElement(0);
    }

    private E getElement(int parentIndex) {
        return this.elements.get(parentIndex);
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }
}