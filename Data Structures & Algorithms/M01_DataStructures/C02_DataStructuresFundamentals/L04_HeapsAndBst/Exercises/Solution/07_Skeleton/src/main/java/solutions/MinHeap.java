package solutions;

import interfaces.Decrease;
import interfaces.Heap;

public class MinHeap<E extends Comparable<E> & Decrease<E>> implements Heap<E> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(E element) {

    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public void decrease(E element) {

    }
}
