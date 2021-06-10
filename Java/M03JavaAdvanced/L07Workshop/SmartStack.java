package bg.softuni.java_advanced.workshop;

import java.util.function.Consumer;

public class SmartStack {
    private static class Node {
        int element;
        Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    public SmartStack() {
    }

    public void push(int element) {
        Node newNode = new Node(element);
        if (this.top != null) {
            newNode.prev = this.top;
        }
        this.top = newNode;

        this.size++;
    }

    public int peek() {
        ensureNonEmpty("peek");
        return this.top.element;
    }

    public int pop() {
        ensureNonEmpty("pop");
        int element = this.top.element;
        this.top = this.top.prev;
        this.size--;
        return element;
    }

    private void ensureNonEmpty(String operation) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot " + operation
                    + " on empty stack");
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = this.top;

        while (current != null) {
            consumer.accept(current.element);
            current = current.prev;
        }
    }
}
