import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTreeTests {

    @Test
    public void insert_SingleElement_ShouldIncreaseCount() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        rbt.insert(5);

        Assert.assertEquals(1, rbt.getNodesCount());
    }

    @Test
    public void insert_MultipleElements_ShouldBeInsertedCorrectly()  {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        rbt.insert(5);
        rbt.insert(12);
        rbt.insert(18);
        rbt.insert(37);
        rbt.insert(48);
        rbt.insert(60);
        rbt.insert(80);

        List<Integer> nodes = new ArrayList<>();
        rbt.eachInOrder(nodes::add);

        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[] { 5, 12, 18, 37, 48, 60, 80 };

        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void insert_multipleElements_shouldBeBalanced() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        rbt.insert(5);
        rbt.insert(12);
        rbt.insert(18);
        rbt.insert(37);
        rbt.insert(48);
        rbt.insert(60);
        rbt.insert(80);

        Assert.assertEquals(7, rbt.getNodesCount());
        Assert.assertEquals(3, rbt.search(12).getNodesCount());
        Assert.assertEquals(3, rbt.search(60).getNodesCount());
    }


    @Test
    public void insert_MultipleElements_ShouldHaveQuickFind() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();

        for (int i = 0; i < 100000; i++) {
            rbt.insert(i);
        }

        Assert.assertEquals(true, rbt.contains(99999));
    }
}
