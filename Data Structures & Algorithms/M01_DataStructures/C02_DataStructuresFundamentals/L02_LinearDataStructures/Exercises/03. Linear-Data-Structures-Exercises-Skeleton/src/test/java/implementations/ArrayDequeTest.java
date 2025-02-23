package implementations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    private ArrayDeque<String> arrayDeque;

    @Before
    public void setUp() {
        this.arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 2; i++) {
            arrayDeque.add(String.valueOf(i));
        }
    }

    @Test
    public void testAddShouldAddAnElementAtTheEnd() {
        arrayDeque.add("2");
        assertEquals(3, arrayDeque.size());
        assertEquals("2", arrayDeque.get(2));
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