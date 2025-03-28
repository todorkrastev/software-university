import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoThreeTreeTest {

    @Test
    public void testInsertSingle() {
        TwoThreeTree<Integer> tree = new TwoThreeTree<>();
        tree.insert(13);
        assertEquals("13", tree.getAsString());
    }

    @Test
    public void testInsertMany() {
        TwoThreeTree<Integer> tree = new TwoThreeTree<>();
        tree.insert(13);
        tree.insert(42);
        tree.insert(69);
        assertEquals("42 " + System.lineSeparator() +
                "13 " + System.lineSeparator() +
                "69", tree.getAsString());
    }

    @Test
    public void testInsert13Elements() {
        TwoThreeTree<Integer> tree = new TwoThreeTree<>();

        int[] arr = {5494, 1937, 6209, 707, 1593, 2002, 2736, 8168, 6541, 6209, 6254, 7037, 8168};

        for (int i = 0; i < 13; i++) {
            tree.insert(arr[i]);
        }

        assertEquals("2002 6209" + System.lineSeparator() +
                "1593 " + System.lineSeparator() +
                "707 " + System.lineSeparator() +
                "1937 " + System.lineSeparator() +
                "5494 " + System.lineSeparator() +
                "2736 " + System.lineSeparator() +
                "6209 " + System.lineSeparator() +
                "6541 8168" + System.lineSeparator() +
                "6254 " + System.lineSeparator() +
                "7037 " + System.lineSeparator() +
                "8168", tree.getAsString());
    }
}