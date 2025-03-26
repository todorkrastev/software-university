import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AVLTest {

    @Test
    public void traverseInOrder_AfterSingleInsert() {
        // Arrange
        AVL<Integer> avl = new AVL<>();
        avl.insert(1);

        // Act
        List<Integer> nodes = new ArrayList<>();
        avl.eachInOrder(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[]{1};
        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void traverseInOrder_AfterMultipleInserts() {
        // Arrange
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(2);
        avl.insert(1);
        avl.insert(3);

        // Act
        List<Integer> nodes = new ArrayList<>();
        avl.eachInOrder(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[]{1, 2, 3};
        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void contains_ExistingElement_ShouldReturnTrue() {
        // Arrange
        AVL<Integer> avl = new AVL<>();
        avl.insert(2);
        avl.insert(1);
        avl.insert(3);

        // Act
        // Assert
        Assert.assertTrue(avl.contains(1));
        Assert.assertTrue(avl.contains(2));
        Assert.assertTrue(avl.contains(3));
    }

    @Test
    public void contains_NonExistingElement_ShouldReturnFalse() {
        // Arrange
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(2);
        avl.insert(1);
        avl.insert(3);

        // Act
        // Assert
        Assert.assertFalse(avl.contains(5));
    }

    @Test
    public void height_RootRight() {
        // Arrange
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(1);
        avl.insert(2);

        // Act
        // Assert
        Assert.assertEquals(2, avl.getRoot().height);
        Assert.assertEquals(1, avl.getRoot().right.height);
    }

    @Test
    public void height_RootLeft() {
        // Arrange
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(2);
        avl.insert(1);

        // Act
        // Assert
        Assert.assertEquals(2, avl.getRoot().height);
        Assert.assertEquals(1, avl.getRoot().left.height);
    }

    @Test
    public void height_RootLeftRight() {
        // Arrange
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(2);
        avl.insert(1);
        avl.insert(3);

        // Act
        // Assert
        Assert.assertEquals(2, avl.getRoot().height);
        Assert.assertEquals(1, avl.getRoot().left.height);
        Assert.assertEquals(1, avl.getRoot().right.height);
    }

    @Test
    public void rebalance_RootShouldHaveHeightTwo() {
        // Arrange
        AVL<Integer> avl = new AVL<Integer>();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);

        // Assert
        Assert.assertEquals(2, avl.getRoot().height);
    }

    @Test
    public void rebalance_TestHeightOneNodes() {
        // Arrange
        AVL<Integer> avl = new AVL<Integer>();
        for (int i = 1; i < 10; i++) {
            avl.insert(i);
        }

        // Assert
        Assert.assertEquals(1, avl.getRoot().left.left.height); // 1
        Assert.assertEquals(1, avl.getRoot().left.right.height); // 3
        Assert.assertEquals(1, avl.getRoot().right.left.height); // 5
        Assert.assertEquals(1, avl.getRoot().right.right.left.height); // 7
        Assert.assertEquals(1, avl.getRoot().right.right.right.height); // 9
    }

    @Test
    public void rebalance_TestHeightTwoNodes() {
        // Arrange
        AVL<Integer> avl = new AVL<Integer>();
        for (int i = 1; i < 10; i++) {
            avl.insert(i);
        }

        // Assert
        Assert.assertEquals(2, avl.getRoot().left.height); // 2
        Assert.assertEquals(2, avl.getRoot().right.right.height); // 8
    }

    @Test
    public void rebalance_TestHeightThreeNodes() {
        // Arrange
        AVL<Integer> avl = new AVL<Integer>();
        for (int i = 1; i < 10; i++) {
            avl.insert(i);
        }

        // Assert
        Assert.assertEquals(3, avl.getRoot().right.height); // 6
    }

    @Test
    public void rebalance_TestHeightFourNodes() {
        // Arrange
        AVL<Integer> avl = new AVL<Integer>();
        for (int i = 1; i < 10; i++) {
            avl.insert(i);
        }

        // Assert
        Assert.assertEquals(4, avl.getRoot().height); // 4
    }

    @Test
    public void rebalance_SingleRight() {
        // Arrange
        AVL<Integer> avl = new AVL<Integer>();

        // Act
        avl.insert(3);
        avl.insert(2);
        avl.insert(1);

        // Assert
        Assert.assertEquals(Integer.valueOf(2), avl.getRoot().value);
    }

    @Test
    public void rebalance_SingleLeft()
    {
        // Arrange
        AVL<Integer> avl = new AVL<>();

        // Act
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);

        // Assert
        Assert.assertEquals(Integer.valueOf(2), avl.getRoot().value);
    }

    @Test
    public void rebalance_DoubleLeft() {
        // Arrange
        AVL<Integer> avl = new AVL<Integer>();

        // Act
        avl.insert(5);
        avl.insert(7);
        avl.insert(6);

        // Assert
        Assert.assertEquals(Integer.valueOf(6), avl.getRoot().value);
        Assert.assertEquals(2, avl.getRoot().height);
        Assert.assertEquals(1, avl.getRoot().left.height);
        Assert.assertEquals(1, avl.getRoot().right.height);
    }
}
