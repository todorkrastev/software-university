import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AVLTest {

    // INSERT

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
        AVL<Integer> avl = new AVL<>();
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
        AVL<Integer> avl = new AVL<>();
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
        AVL<Integer> avl = new AVL<>();
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
        AVL<Integer> avl = new AVL<>();
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
        AVL<Integer> avl = new AVL<>();
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
        AVL<Integer> avl = new AVL<>();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);

        // Assert
        Assert.assertEquals(2, avl.getRoot().height);
    }

    @Test
    public void rebalance_TestHeightOneNodes() {
        // Arrange
        AVL<Integer> avl = new AVL<>();
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
        AVL<Integer> avl = new AVL<>();
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
        AVL<Integer> avl = new AVL<>();
        for (int i = 1; i < 10; i++) {
            avl.insert(i);
        }

        // Assert
        Assert.assertEquals(3, avl.getRoot().right.height); // 6
    }

    @Test
    public void rebalance_TestHeightFourNodes() {
        // Arrange
        AVL<Integer> avl = new AVL<>();
        for (int i = 1; i < 10; i++) {
            avl.insert(i);
        }

        // Assert
        Assert.assertEquals(4, avl.getRoot().height); // 4
    }

    @Test
    public void rebalance_SingleRight() {
        // Arrange
        AVL<Integer> avl = new AVL<>();

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
        AVL<Integer> avl = new AVL<>();

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

    // DELETE

    @Test
    public void height_DeleteRoot() {
        // Arrange
        AVL<Integer> avl = new AVL<>();
        for (int i = 1; i < 10; i++) {
            avl.insert(i);
        }

        avl.delete(4);

        Node<Integer> root = avl.getRoot();

        // Assert
        Assert.assertEquals(Integer.valueOf(5), root.value);
        Assert.assertEquals(4, root.height);

        // Nodes of height 1
        Assert.assertEquals(1, root.left.left.height); // 1
        Assert.assertEquals(1, root.left.right.height); // 3
        Assert.assertEquals(1, root.right.left.right.height); // 7
        Assert.assertEquals(1, root.right.right.height); // 9

        // Nodes of height 2
        Assert.assertEquals(2, root.left.height); // 2
        Assert.assertEquals(2, root.right.left.height); //6

        // Nodes of height 3
        Assert.assertEquals(3, root.right.height); // 8

        // Nodes of height 4
        Assert.assertEquals(4, root.height); // 5
    }

    @Test
    public void height_DeleteMultiple() {
        // Arrange
        AVL<Integer> avl = new AVL<>();
        for (int i = 1; i < 10; i++) {
            avl.insert(i);
        }

        avl.delete(4);
        avl.delete(2);
        avl.delete(1);

        Node<Integer> root = avl.getRoot();

        // Assert
        Assert.assertEquals(Integer.valueOf(6), root.value);
        Assert.assertEquals(3, root.height);

        // Nodes of height 1
        Assert.assertEquals(Integer.valueOf(3), root.left.left.value);
        Assert.assertEquals(1, root.left.left.height); // 3

        Assert.assertEquals(Integer.valueOf(7), root.right.left.value);
        Assert.assertEquals(1, root.right.left.height); // 7

        Assert.assertEquals(Integer.valueOf(9), root.right.right.value);
        Assert.assertEquals(1, root.right.right.height); // 9

        // Nodes of height 2
        Assert.assertEquals(Integer.valueOf(5), root.left.value);
        Assert.assertEquals(2, root.left.height); // 5

        Assert.assertEquals(Integer.valueOf(8), root.right.value);
        Assert.assertEquals(2, root.right.height); // 8
    }

    @Test
    public void insert_Multiple_DeleteMin_Should_Work_Correctly() {
        // Arrange
        AVL<Integer> avl = new AVL<>();
        avl.insert(2);
        avl.insert(1);
        avl.insert(3);

        // Act
        avl.deleteMin();
        List<Integer> nodes = new ArrayList<>();
        avl.eachInOrder(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[] { 2, 3 };
        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void deleteMin_Empty_Tree_Should_Work_Correctly() {
        // Arrange
        AVL<Integer> avl = new AVL<>();

        // Act
        avl.deleteMin();
        List<Integer> nodes = new ArrayList<>();
        avl.eachInOrder(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[] { };
        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void deleteMin_One_Element_Should_Work_Correctly() {
        // Arrange
        AVL<Integer> avl = new AVL<>();
        avl.insert(1);

        // Act
        avl.deleteMin();
        List<Integer> nodes = new ArrayList<>();
        avl.eachInOrder(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[] { };
        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void delete_LeftLeaf() {
        AVL<Integer> avl = new AVL<>();

        avl.insert(5);
        avl.insert(3);
        avl.insert(1);
        avl.insert(4);
        avl.insert(8);
        avl.insert(9);

        // Act
        avl.delete(1);
        List<Integer> nodes = new ArrayList<>();
        avl.eachInOrder(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[] { 3, 4, 5, 8, 9 };
        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void delete_RightLeaf() {
        AVL<Integer> avl = new AVL<>();

        avl.insert(5);
        avl.insert(3);
        avl.insert(1);
        avl.insert(4);
        avl.insert(8);
        avl.insert(9);

        // Act
        avl.delete(4);
        List<Integer> nodes = new ArrayList<>();
        avl.eachInOrder(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[] { 1, 3, 5, 8, 9 };
        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void delete_NodeWithRightChild() {
        AVL<Integer> avl = new AVL<>();

        avl.insert(5);
        avl.insert(3);
        avl.insert(1);
        avl.insert(4);
        avl.insert(8);
        avl.insert(9);

        // Act
        avl.delete(8);
        List<Integer> nodes = new ArrayList<>();
        avl.eachInOrder(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[] { 1, 3, 4, 5, 9 };
        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void delete_NodeWithLeftChild() {
        AVL<Integer> avl = new AVL<>();

        avl.insert(5);
        avl.insert(3);
        avl.insert(1);
        avl.insert(4);
        avl.insert(8);
        avl.insert(9);

        // Act
        avl.delete(4);
        avl.delete(3);
        List<Integer> nodes = new ArrayList<>();
        avl.eachInOrder(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[] { 1, 5, 8, 9 };
        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void delete_NodeWithTwoChildren() {
        AVL<Integer> avl = new AVL<>();

        avl.insert(5);
        avl.insert(3);
        avl.insert(1);
        avl.insert(4);
        avl.insert(8);
        avl.insert(9);

        // Act
        avl.delete(3);
        List<Integer> nodes = new ArrayList<>();
        avl.eachInOrder(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[] { 1, 4, 5, 8, 9 };
        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void delete_Root() {
        AVL<Integer> avl = new AVL<>();

        avl.insert(5);
        avl.insert(3);
        avl.insert(1);
        avl.insert(4);
        avl.insert(8);
        avl.insert(9);

        // Act
        avl.delete(5);
        List<Integer> nodes = new ArrayList<>();
        avl.eachInOrder(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[] { 1, 3, 4, 8, 9 };
        Assert.assertArrayEquals(expectedNodes, result);
    }

    @Test
    public void delete_Root_EmptyTree() {
        AVL<Integer> avl = new AVL<>();

        // Act
        avl.delete(5);
        List<Integer> nodes = new ArrayList<>();
        avl.eachInOrder(nodes::add);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            result[i] = nodes.get(i);
        }

        // Assert
        int[] expectedNodes = new int[] { };
        Assert.assertArrayEquals(expectedNodes, result);
    }
}
