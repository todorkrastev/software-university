package main;

import java.util.ArrayList;
import java.util.List;

public class HierarchyNode<T> {
    private T value;
    private HierarchyNode<T> parent;
    private List<HierarchyNode<T>> children;

    public HierarchyNode(T value) {
        this.value = value;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public HierarchyNode<T> setValue(T value) {
        this.value = value;
        return this;
    }

    public HierarchyNode<T> getParent() {
        return parent;
    }

    public HierarchyNode<T> setParent(HierarchyNode<T> parent) {
        this.parent = parent;
        return this;
    }

    public List<HierarchyNode<T>> getChildren() {
        return children;
    }

    public HierarchyNode<T> setChildren(List<HierarchyNode<T>> children) {
        this.children = children;
        return this;
    }
}
