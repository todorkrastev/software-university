package main;

import java.util.Iterator;

public class Hierarchy<T> implements IHierarchy<T> {


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void add(T element, T child) {

    }

    @Override
    public void remove(T element) {

    }

    @Override
    public Iterable<T> getChildren(T element) {
        return null;
    }

    @Override
    public T getParent(T element) {
        return null;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public Iterable<T> getCommonElements(IHierarchy<T> other) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
