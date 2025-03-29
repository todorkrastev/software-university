package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hierarchy<T> implements IHierarchy<T> {
    private Map<T, HierarchyNode<T>> data;

    public Hierarchy(T element) {
        this.data = new HashMap<>();

        HierarchyNode<T> root = new HierarchyNode<>(element);
        this.data.put(element, root);
    }


    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public void add(T element, T child) {
        HierarchyNode<T> parent = this.data.get(element);
        if (parent == null) {
            throw new IllegalArgumentException("Element not found");
        }

        if (this.data.containsKey(child)) {
            throw new IllegalArgumentException("Child already exists");
        }

        HierarchyNode<T> toBeAdded = new HierarchyNode<>(child);
        toBeAdded.setParent(parent);

        parent.getChildren().add(toBeAdded);

        this.data.put(child, toBeAdded);
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
