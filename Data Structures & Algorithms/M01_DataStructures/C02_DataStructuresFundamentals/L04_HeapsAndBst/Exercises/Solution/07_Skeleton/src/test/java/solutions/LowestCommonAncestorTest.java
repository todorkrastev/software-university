package solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class LowestCommonAncestorTest {

    @Test
    public void testLCA() {
        BinaryTree binaryTree =
                new BinaryTree(7,
                        new BinaryTree(21, null, null),
                        new BinaryTree(14,
                                new BinaryTree(23, null, null),
                                new BinaryTree(6, null,
                                        new BinaryTree(13, null, null))));

        assertEquals(Integer.valueOf(14), binaryTree.findLowestCommonAncestor(23, 13));
    }

}