package implementations;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ReversedListImplTest {
    @Test
    void testAdd() {
        ReversedList<Integer> list = new ReversedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        assertEquals(5, list.size());
        assertEquals(5, list.get(0));
        assertEquals(4, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(2, list.get(3));
        assertEquals(1, list.get(4));
    }

    @Test
    void testRemoveAt() {
        ReversedList<Integer> list = new ReversedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.removeAt(2);
        assertEquals(4, list.size());
        assertEquals(5, list.get(0));
        assertEquals(4, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(1, list.get(3));
    }

    @Test
    void testIterator() {
        ReversedList<Integer> list = new ReversedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertFalse(iterator.hasNext());
    }
}