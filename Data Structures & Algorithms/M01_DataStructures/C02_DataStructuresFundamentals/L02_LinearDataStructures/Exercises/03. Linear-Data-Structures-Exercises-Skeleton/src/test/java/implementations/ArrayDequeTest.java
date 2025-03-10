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
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer("element1");
        assertEquals(1, arrayDeque.size());
        assertEquals("element1", arrayDeque.get(0));

        arrayDeque.offer("element2");
        assertEquals(2, arrayDeque.size());
        assertEquals("element2", arrayDeque.get(1));

        for (int i = 2; i < 10; i++) {
            arrayDeque.offer("element" + i);
        }
        assertEquals(10, arrayDeque.size());
        assertEquals("element9", arrayDeque.get(9));
    }

    @Test
    public void addFirst() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addFirst("element1");
        assertEquals(1, arrayDeque.size());
        assertEquals("element1", arrayDeque.get(0));

        arrayDeque.addFirst("element2");
        assertEquals(2, arrayDeque.size());
        assertEquals("element2", arrayDeque.get(0));

        for (int i = 2; i < 10; i++) {
            arrayDeque.addFirst("element" + i);
        }
        assertEquals(10, arrayDeque.size());
        assertEquals("element9", arrayDeque.get(0));
    }

    @Test
    public void addLast() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast("element1");
        assertEquals(1, arrayDeque.size());
        assertEquals("element1", arrayDeque.get(0));

        arrayDeque.addLast("element2");
        assertEquals(2, arrayDeque.size());
        assertEquals("element2", arrayDeque.get(1));

        for (int i = 2; i < 10; i++) {
            arrayDeque.addLast("element" + i);
        }
        assertEquals(10, arrayDeque.size());
        assertEquals("element9", arrayDeque.get(9));
    }

    @Test
    public void push() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.push("element1");
        assertEquals(1, arrayDeque.size());
        assertEquals("element1", arrayDeque.get(0));

        arrayDeque.push("element2");
        assertEquals(2, arrayDeque.size());
        assertEquals("element2", arrayDeque.get(0));

        for (int i = 2; i < 10; i++) {
            arrayDeque.push("element" + i);
        }
        assertEquals(10, arrayDeque.size());
        assertEquals("element9", arrayDeque.get(0));
    }

    @Test
    public void insert() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.insert(0, "element1");
        assertEquals(1, arrayDeque.size());
        assertEquals("element1", arrayDeque.get(0));

        arrayDeque.insert(0, "element2");
        assertEquals(2, arrayDeque.size());
        assertEquals("element2", arrayDeque.get(0));
        assertEquals("element1", arrayDeque.get(1));

        arrayDeque.insert(1, "element3");
        assertEquals(3, arrayDeque.size());
        assertEquals("element2", arrayDeque.get(0));
        assertEquals("element3", arrayDeque.get(1));
        assertEquals("element1", arrayDeque.get(2));

        arrayDeque.insert(3, "element4");
        assertEquals(4, arrayDeque.size());
        assertEquals("element2", arrayDeque.get(0));
        assertEquals("element3", arrayDeque.get(1));
        assertEquals("element1", arrayDeque.get(2));
        assertEquals("element4", arrayDeque.get(3));
    }

    @Test
    public void set() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("element1");
        arrayDeque.add("element2");
        arrayDeque.add("element3");

        arrayDeque.set(1, "newElement");

        assertEquals(3, arrayDeque.size());
        assertEquals("element1", arrayDeque.get(0));
        assertEquals("newElement", arrayDeque.get(1));
        assertEquals("element3", arrayDeque.get(2));
    }

    @Test
    public void peek() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        assertNull(arrayDeque.peek());

        arrayDeque.add("element1");
        assertEquals("element1", arrayDeque.peek());

        arrayDeque.add("element2");
        assertEquals("element1", arrayDeque.peek());
    }

    @Test
    public void poll() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        assertNull(arrayDeque.poll());

        arrayDeque.add("element2");
        arrayDeque.add("element3");
        assertEquals("element2", arrayDeque.poll());
        assertEquals(1, arrayDeque.size());
        assertEquals("element3", arrayDeque.get(0));
    }

    @Test
    public void pop() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        assertNull(arrayDeque.pop());

        arrayDeque.add("element2");
        arrayDeque.add("element3");
        assertEquals("element3", arrayDeque.pop());
        assertEquals(1, arrayDeque.size());
        assertEquals("element2", arrayDeque.get(0));
    }

    @Test
    public void get() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("element1");
        arrayDeque.add("element2");
        arrayDeque.add("element3");

        assertEquals("element1", arrayDeque.get(0));
        assertEquals("element2", arrayDeque.get(1));
        assertEquals("element3", arrayDeque.get(2));
    }

    @Test
    public void testGet() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("element1");
        arrayDeque.add("element2");
        arrayDeque.add("element3");

        assertEquals("element1", arrayDeque.get("element1"));
        assertEquals("element2", arrayDeque.get("element2"));
        assertEquals("element3", arrayDeque.get("element3"));
        assertNull(arrayDeque.get("element4"));
    }

    @Test
    public void remove() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("element1");
        arrayDeque.add("element2");
        arrayDeque.add("element3");

        assertEquals("element2", arrayDeque.remove(1));
        assertEquals(2, arrayDeque.size());
        assertEquals("element1", arrayDeque.get(0));
        assertEquals("element3", arrayDeque.get(1));
    }

    @Test
    public void testRemove() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("element1");
        arrayDeque.add("element2");
        arrayDeque.add("element3");

        assertEquals("element2", arrayDeque.remove("element2"));
        assertEquals(2, arrayDeque.size());
        assertEquals("element1", arrayDeque.get(0));
        assertEquals("element3", arrayDeque.get(1));

        assertNull(arrayDeque.remove("element4"));
        assertEquals(2, arrayDeque.size());
    }

    @Test
    public void removeFirst() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("element1");
        arrayDeque.add("element2");

        assertEquals("element1", arrayDeque.removeFirst());
        assertEquals(1, arrayDeque.size());
        assertEquals("element2", arrayDeque.get(0));

        assertEquals("element2", arrayDeque.removeFirst());
        assertEquals(0, arrayDeque.size());
        assertNull(arrayDeque.removeFirst());
    }

    @Test
    public void removeLast() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("element1");
        arrayDeque.add("element2");

        assertEquals("element2", arrayDeque.removeLast());
        assertEquals(1, arrayDeque.size());
        assertEquals("element1", arrayDeque.get(0));

        assertEquals("element1", arrayDeque.removeLast());
        assertEquals(0, arrayDeque.size());
        assertNull(arrayDeque.removeLast());
    }

    @Test
    public void size() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        assertEquals(0, arrayDeque.size());

        arrayDeque.add("element1");
        assertEquals(1, arrayDeque.size());

        arrayDeque.add("element2");
        assertEquals(2, arrayDeque.size());
    }

    @Test
    public void capacity() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        assertEquals(7, arrayDeque.capacity());
    }

    @Test
    public void trimToSize() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("element1");
        arrayDeque.add("element2");
        arrayDeque.trimToSize();

        assertEquals(2, arrayDeque.size());
        assertEquals(2, arrayDeque.capacity());

        assertEquals("element1", arrayDeque.get(0));
        assertEquals("element2", arrayDeque.get(1));
    }

    @Test
    public void isEmpty() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        assertTrue(arrayDeque.isEmpty());

        arrayDeque.add("element1");
        assertFalse(arrayDeque.isEmpty());
    }
}