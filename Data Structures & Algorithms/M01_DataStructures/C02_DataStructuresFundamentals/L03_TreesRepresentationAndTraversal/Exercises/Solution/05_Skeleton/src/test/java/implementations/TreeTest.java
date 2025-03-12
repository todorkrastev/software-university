package implementations;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TreeTest {

    @Test
    public void testTreeCreation() {
        String[] input = {
                "19 1",
                "19 12",
                "19 31",
                "14 23",
                "14 6",
                "7 19",
                "7 21",
                "7 14"
        };


        TreeFactory treeFactory = new TreeFactory();
        Tree<Integer> tree = treeFactory.createTreeFromStrings(input);

        assertEquals(Integer.valueOf(7), tree.getKey());
    }

    @Test
    public void testTreeAsString() {
        String[] input = {
                "7 19",
                "7 21",
                "7 14",
                "19 1",
                "19 12",
                "19 31",
                "14 23",
                "14 6"
        };


        TreeFactory treeFactory = new TreeFactory();
        Tree<Integer> tree = treeFactory.createTreeFromStrings(input);

        assertEquals("7\r\n" +
                "  19\r\n" +
                "    1\r\n" +
                "    12\r\n" +
                "    31\r\n" +
                "  21\r\n" +
                "  14\r\n" +
                "    23\r\n" +
                "    6", tree.getAsString());
    }

    @Test
    public void testLeafKeys() {
        String[] input = {
                "7 19",
                "7 21",
                "7 14",
                "19 1",
                "19 12",
                "19 31",
                "14 23",
                "14 6"
        };

        TreeFactory treeFactory = new TreeFactory();
        Tree<Integer> tree = treeFactory.createTreeFromStrings(input);

        List<Integer> leafKeys = tree.getLeafKeys();
        Collections.sort(leafKeys);

        assertEquals(List.of(1, 6, 12, 21, 23, 31), leafKeys);
    }

    @Test
    public void testMiddleNodes() {
        String[] input = {
                "7 19",
                "7 21",
                "7 14",
                "19 1",
                "19 12",
                "19 31",
                "14 23",
                "14 6"
        };

        TreeFactory treeFactory = new TreeFactory();
        Tree<Integer> tree = treeFactory.createTreeFromStrings(input);

        List<Integer> leafKeys = tree.getMiddleKeys();
        Collections.sort(leafKeys);

        assertEquals(List.of(14, 19), leafKeys);
    }

    @Test
    public void testDeepestLeftmostNode() {
        String[] input = {
                "7 19",
                "7 21",
                "7 14",
                "19 1",
                "19 12",
                "19 31",
                "14 23",
                "14 6"
        };

        TreeFactory treeFactory = new TreeFactory();
        Tree<Integer> tree = treeFactory.createTreeFromStrings(input);

        Tree<Integer> deepestLeftmostNode = tree.getDeepestLeftmostNode();

        assertEquals(Integer.valueOf(1), deepestLeftmostNode.getKey());
    }

    @Test
    public void testLongestPath() {
        String[] input = {
                "7 19",
                "7 21",
                "7 14",
                "19 1",
                "19 12",
                "19 31",
                "14 23",
                "14 6"
        };
        TreeFactory treeFactory = new TreeFactory();
        Tree<Integer> tree = treeFactory.createTreeFromStrings(input);

        List<Integer> longestPath = tree.getLongestPath();

        assertEquals(List.of(7, 19, 1), longestPath);
    }

    @Test
    public void testPathsWithGivenSum() {
        String[] input = {
                "7 19",
                "7 21",
                "7 14",
                "19 1",
                "19 12",
                "19 31",
                "14 23",
                "14 6"
        };
        TreeFactory treeFactory = new TreeFactory();
        Tree<Integer> tree = treeFactory.createTreeFromStrings(input);

        List<List<Integer>> lists = tree.pathsWithGivenSum(27);

        List<List<Integer>> expected =
                List.of(List.of(7, 19, 1), List.of(7, 14, 6));

        for (int i = 0; i < lists.size(); i++) {
            assertEquals(expected.get(i), lists.get(i));
        }
    }

    @Test
    public void testTreesWithGivenSum() {
        String[] input = {
                "7 19",
                "7 21",
                "7 14",
                "19 1",
                "19 12",
                "19 31",
                "14 23",
                "14 6"
        };
        TreeFactory treeFactory = new TreeFactory();
        Tree<Integer> tree = treeFactory.createTreeFromStrings(input);
        List<Tree<Integer>> trees = tree.subTreesWithGivenSum(43);
        String asString = trees.get(0).getAsString();
        assertTrue(asString.contains("14"));
        assertTrue(asString.contains("23"));
        assertTrue(asString.contains("6"));
    }
}