package implementations;

import interfaces.AbstractQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {
    private final List<E> elements;

    public PriorityQueue() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(this.elements.size() - 1);
    }

    @Override
    public E peek() {
        ensureElement();
        return getElement(0);
    }

    private void ensureElement() {
        if (this.elements.isEmpty()) throw new IllegalStateException("Illegal call to peek on empty heap");
    }

    @Override
    public E poll() {
        ensureElement();
        Collections.swap(this.elements, 0, this.elements.size() - 1);
        E peek = this.elements.remove(this.elements.size() - 1);
        this.heapifyDown(0);
        return peek;
    }

    private void heapifyDown(int index) {
        while (getLeftChildIndex(index) < this.size() && isLessThan(index, getLeftChildIndex(index))) {
            int childIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            if (rightChildIndex < this.size() && isLessThan(childIndex, rightChildIndex)) {
                childIndex = rightChildIndex;
            }

            Collections.swap(this.elements, childIndex, index);
            index = childIndex;
        }
    }

    private int getLeftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
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

    private E getElement(int parentIndex) {
        return this.elements.get(parentIndex);
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }
}