package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void sort() {
        int[] arr = {13, -1, 56, 98, 43, 0};
        int[] expected = {-1, 0, 13, 43, 56, 98};
        Bubble.sort(arr);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], arr[i]);
        }
    }
}