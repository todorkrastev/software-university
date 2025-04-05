import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AATreeTest {
    private AATree<Integer> aaTree;
    private Integer[] input = {
            18,
            13,
            1,
            7,
            42,
            73,
            56,
            24,
            6,
            2,
            74,
            69,
            55
    };

    @Before
    public void setUp() {
        this.aaTree = new AATree<>();

        for (Integer integer : input) {
            this.aaTree.insert(integer);
        }
    }

    @Test
    public void testCreation() {
        List<Integer> numbers = new ArrayList<>();
        this.aaTree.inOrder(numbers::add);
        List<Integer> expected = Arrays.stream(input)
                .sorted()
                .collect(Collectors.toList());

        assertEquals(expected.size(), numbers.size());

        assertEquals(expected, numbers);
    }

    @Test
    public void countNodes() {
        assertEquals(13, this.aaTree.countNodes());
        assertEquals(0, new AATree<>().countNodes());
    }

    @Test
    public void isEmpty() {
        assertFalse(this.aaTree.isEmpty());
        assertTrue(new AATree<>().isEmpty());
    }

    @Test
    public void search() {
        assertTrue(this.aaTree.search(73));
        assertFalse(new AATree<Integer>().search(100));
    }

    @Test
    public void preOrder() {
        List<Integer> actual = new ArrayList<>();
        this.aaTree.preOrder(actual::add);

        List<Integer> expected = List.of(13, 6, 1, 2, 7, 56, 42, 18, 24, 55, 73, 69, 74);

        assertEquals(expected, actual);
    }

    @Test
    public void inOrder() {
        List<Integer> actual = new ArrayList<>();
        this.aaTree.inOrder(actual::add);

        List<Integer> expected = List.of(1, 2, 6, 7, 13, 18, 24, 42, 55, 56, 69, 73, 74);

        assertEquals(expected, actual);
    }

    @Test
    public void postOrder() {
        List<Integer> actual = new ArrayList<>();
        this.aaTree.postOrder(actual::add);

        List<Integer> expected = List.of(2, 1, 7, 6, 24, 18, 55, 42, 69, 74, 73, 56, 13);

        assertEquals(expected, actual);
    }
}