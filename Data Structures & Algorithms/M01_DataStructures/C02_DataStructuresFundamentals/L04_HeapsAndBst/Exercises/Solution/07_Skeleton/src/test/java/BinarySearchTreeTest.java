import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void testInsertAndContains() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertTrue(bst.contains(5));
        assertTrue(bst.contains(3));
        assertTrue(bst.contains(7));
        assertFalse(bst.contains(4));
    }

    @Test
    public void testEachInOrder() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        List<Integer> result = new ArrayList<>();
        bst.eachInOrder(result::add);

        assertEquals(List.of(3, 5, 7), result);
    }

    @Test
    public void testRange() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        List<Integer> result = bst.range(3, 7);

        assertEquals(List.of(3, 4, 5, 6), result);
    }

    @Test
    public void testDeleteMin() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);

        bst.deleteMin();

        assertFalse(bst.contains(2));
        assertTrue(bst.contains(3));
    }

    @Test
    public void testDeleteMax() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(8);

        bst.deleteMax();

        assertFalse(bst.contains(8));
        assertTrue(bst.contains(7));
    }

    @Test
    public void testCount() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertEquals(3, bst.count());
    }

    @Test
    public void testRank() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);

        assertEquals(2, bst.rank(4));
        assertEquals(4, bst.rank(7));
    }

    @Test
    public void testFloor() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertEquals(Integer.valueOf(5), bst.floor(6));
        assertEquals(Integer.valueOf(3), bst.floor(4));
    }

    @Test
    public void testCeil() {
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);

        assertEquals(Integer.valueOf(7), bst.ceil(6));
        assertEquals(Integer.valueOf(5), bst.ceil(4));
    }
}