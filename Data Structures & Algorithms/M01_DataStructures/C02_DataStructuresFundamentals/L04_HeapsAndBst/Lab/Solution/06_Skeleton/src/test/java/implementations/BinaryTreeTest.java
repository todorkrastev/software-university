package implementations;

import interfaces.AbstractBinaryTree;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    private AbstractBinaryTree<Integer> tree;

    @Before
    public void setUp() {
        this.tree = new BinaryTree<>(17,
                new BinaryTree<>(9, new BinaryTree<>(3, null, null),
                        new BinaryTree<>(11, null, null)),
                new BinaryTree<>(25, new BinaryTree<>(20, null, null),
                        new BinaryTree<>(31, null, null))
        );
    }

    @Test
    public void testAsIndentedPreOrder() {
        String indentedPreOrder = this.tree.asIndentedPreOrder(0);
        assertEquals(
                "17\r\n" +
                "  9\r\n" +
                "    3\r\n" +
                "    11\r\n" +
                "  25\r\n" +
                "    20\r\n" +
                "    31", indentedPreOrder);
    }

    @Test
    public void testPreOrder() {
        List<AbstractBinaryTree<Integer>> trees = this.tree.preOrder();
        Integer[] expected = {17, 9, 3, 11, 25, 20, 31};
        assertEquals(expected.length, trees.size());
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], trees.get(i).getKey());
        }
    }

    @Test
    public void testInOrder() {
        List<AbstractBinaryTree<Integer>> trees = this.tree.inOrder();
        Integer[] expected = {3, 9, 11, 17, 20, 25, 31};
        assertEquals(expected.length, trees.size());
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], trees.get(i).getKey());
        }
    }

    @Test
    public void testPostOrder() {
        List<AbstractBinaryTree<Integer>> trees = this.tree.postOrder();
        Integer[] expected = {3, 11, 9, 20, 31, 25, 17};
        assertEquals(expected.length, trees.size());
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], trees.get(i).getKey());
        }
    }

    @Test
    public void testForEachInOrder() {
        String expected = "3, 9, 11, 17, 20, 25, 31";
        StringBuilder builder = new StringBuilder();
        tree.forEachInOrder(key -> builder.append(key).append(", "));
        String actual = builder.toString();
        assertTrue(builder.length() > 0);
        assertTrue(actual.contains(", "));
        assertEquals(expected, actual.substring(0, actual.lastIndexOf(", ")));
    }
}