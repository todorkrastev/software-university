package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E element) {
            this.value = element;
            this.next = null;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> nextElement = new Node<>(element);

        nextElement.next = this.head;
        this.head = nextElement;

        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> lastElement = new Node<>(element);

        if (this.isEmpty()) {
            this.head = lastElement;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = lastElement;
        }

        this.size++;
    }

    @Override
    public E removeFirst() {
        ensureNotEmtpy();

        E element = this.head.value;
        this.head = this.head.next;
        this.size--;

        return element;
    }

    @Override
    public E removeLast() {
        ensureNotEmtpy();

        if (this.size == 1) {
            E element = this.head.value;
            this.head = null;
            this.size--;
            return element;
        }

        Node<E> current = this.head;
        while (current.next.next != null) {
            current = current.next;
        }

        E element = current.next.value;
        current.next = null;
        this.size--;

        return element;
    }

    @Override
    public E getFirst() {
        ensureNotEmtpy();

        return this.head.value;
    }

    @Override
    public E getLast() {
        ensureNotEmtpy();

        Node<E> current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        return current.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.value;
                current = current.next;
                return element;
            }
        };
    }

    private void ensureNotEmtpy() {
        if (this.isEmpty()) {
            throw new IllegalStateException("The list is empty");
        }
    }
}
