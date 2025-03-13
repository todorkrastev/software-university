package interfaces;

public interface Heap<E extends Comparable<E>> {
    int size();
    void add(E element);
    E peek();
}
