import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class RedBlackTreeTests {
    private RedBlackTree<String, Integer> redBlackTree;
    private String[] input = {
            "S",
            "E",
            "A",
            "R",
            "C",
            "H",
            "E",
            "X",
            "A",
            "M",
            "P",
            "L",
            "E"
    };

    @Before
    public void setUp() {
        this.redBlackTree = new RedBlackTree<>();

        for (int i = 0; i < input.length; i++) {
            this.redBlackTree.put(input[i], i);
        }
    }

    @Test
    public void testCreation() {
        Map<String, Integer> expected = Map.of(
                "A", 8,
                "C", 4,
                "E", 12,
                "H", 5,
                "L", 11,
                "M", 9,
                "P", 10,
                "R", 3,
                "S", 0,
                "X", 7);

        assertEquals(expected.size(), this.redBlackTree.size());

        for (String key : this.redBlackTree.keys()) {
            assertTrue(expected.containsKey(key));
            Integer actual = this.redBlackTree.get(key);
            assertEquals(expected.get(key), actual);
        }
    }

    @Test
    public void size() {
        assertEquals(10, this.redBlackTree.size());
        assertEquals(0, new RedBlackTree<>().size());
    }

    @Test
    public void isEmpty() {
        assertFalse(this.redBlackTree.isEmpty());
        assertTrue(new RedBlackTree<>().isEmpty());
    }

    @Test
    public void get() {
        Integer result = this.redBlackTree.get("H");
        assertNotNull(result);
        assertEquals(Integer.valueOf(5), result);
    }

    @Test
    public void contains() {
        assertTrue(this.redBlackTree.contains("H"));
        assertFalse(new RedBlackTree<String, Integer>().contains("H"));
    }

    @Test
    public void put() {
        this.redBlackTree.put("Z", 73);
        assertEquals(11, this.redBlackTree.size());
        assertTrue(this.redBlackTree.contains("Z"));
    }

    @Test
    public void deleteMin() {
        this.redBlackTree.deleteMin();
        assertEquals(9, this.redBlackTree.size());
        assertFalse(this.redBlackTree.contains("A"));
    }

    @Test
    public void deleteMax() {
        this.redBlackTree.deleteMax();
        assertEquals(9, this.redBlackTree.size());
        assertFalse(this.redBlackTree.contains("X"));
    }

    @Test
    public void delete() {
        this.redBlackTree.delete("H");
        assertEquals(9, this.redBlackTree.size());
        assertFalse(this.redBlackTree.contains("H"));
    }

    @Test
    public void height() {
        assertEquals(3, this.redBlackTree.height());
        assertEquals(-1, new RedBlackTree<>().height());
        RedBlackTree<String, Integer> rbt = new RedBlackTree<>();
        rbt.put("Z", 73);
        assertEquals(0, rbt.height());
        assertEquals(-1, new RedBlackTree<>().height());
    }

    @Test
    public void min() {
        String min = this.redBlackTree.min();
        assertNotNull(min);
        assertEquals("A", min);
        assertEquals(10, this.redBlackTree.size());
    }

    @Test
    public void max() {
        String max = this.redBlackTree.max();
        assertNotNull(max);
        assertEquals("X", max);
        assertEquals(10, this.redBlackTree.size());
    }

    @Test
    public void floor() {
        String floor = this.redBlackTree.floor("G");
        assertNotNull(floor);
        assertEquals("E", floor);
    }

    @Test
    public void ceiling() {
        String ceiling = this.redBlackTree.ceiling("X");
        assertNotNull(ceiling);
        assertEquals("X", ceiling);
    }
	
    @Test
    public void select() {
        String selected = this.redBlackTree.select(3);
        assertNotNull(selected);
        assertEquals("H", selected);
    }

    @Test
    public void rank() {
        int rank = this.redBlackTree.rank("H");
        assertEquals(3, rank);
    }

    @Test
    public void keys() {
        Map<String, Integer> expected = Map.of(
                "A", 8,
                "C", 4,
                "E", 12,
                "H", 5,
                "L", 11,
                "M", 9,
                "P", 10,
                "R", 3,
                "S", 0,
                "X", 7);

        assertEquals(expected.size(), this.redBlackTree.size());

        for (String key : this.redBlackTree.keys()) {
            assertTrue(expected.containsKey(key));
        }
    }
}
