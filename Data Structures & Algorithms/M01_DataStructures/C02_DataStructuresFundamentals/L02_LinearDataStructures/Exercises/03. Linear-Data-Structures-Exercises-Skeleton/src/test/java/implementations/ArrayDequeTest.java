package implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void testAdd() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("element1");
        assertEquals(1, arrayDeque.size());

        arrayDeque.add("element2");
        assertEquals(2, arrayDeque.size());

        for (int i = 2; i < 10; i++) {
            arrayDeque.add("element" + i);
        }
        assertEquals(10, arrayDeque.size());
    }

    @Test
    public void offer() {
    }

    @Test
    public void addFirst() {
    }

    @Test
    public void addLast() {
    }

    @Test
    public void push() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void set() {
    }

    @Test
    public void peek() {
    }

    @Test
    public void poll() {
    }

    @Test
    public void pop() {
    }

    @Test
    public void get() {
    }

    @Test
    public void testGet() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void removeFirst() {
    }

    @Test
    public void removeLast() {
    }

    @Test
    public void size() {
    }

    @Test
    public void capacity() {
    }

    @Test
    public void trimToSize() {
    }

    @Test
    public void isEmpty() {
    }
}