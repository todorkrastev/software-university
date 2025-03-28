package test.performance;

import main.Hierarchy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.helpers.BasePerformanceTest;
import test.helpers.IterableExtensions;
import test.types.PerformanceTests;

import java.util.Arrays;

public class RemovePerformance extends BasePerformanceTest {

    @Category(PerformanceTests.class)
    @Test
    public void PerformanceRemove_With2GroupsOf25000RemovalsWith50000Elements()
    {
        int count = 50001;
        int counter1 = 1;
        int counter2 = 25001;
        Hierarchy<Integer> hierarchy = new Hierarchy<>(-1);
        hierarchy.add(-1, 1);
        hierarchy.add(-1, 25001);
        for (int i = 1; i < 25000; i++)
        {
            hierarchy.add(counter1, ++counter1);
            hierarchy.add(counter2, ++counter2);
        }


        long start = System.currentTimeMillis();
        for (int i = 1; i < 25001; i++)
        {
            hierarchy.remove(i);
            hierarchy.remove(25000 + i);
            count -= 2;
            Assert.assertEquals(count, hierarchy.getCount());
        }
        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 200);

        Assert.assertEquals("Incorrect count after removal!", 1, hierarchy.getCount());
        Assert.assertTrue(hierarchy.contains(-1));
        Assert.assertEquals("Children were not deleted correcly after removal!", 0, IterableExtensions.getCount(hierarchy.getChildren(-1)));
    }

    @Category(PerformanceTests.class)
    @Test
    public void PerformanceRemove_With20000RemovalsIn4GroupsInReverseOrderFromTheMiddleWith40000Elements()
    {
        int counter1 = 10000;
        int counter2 = 20000;
        int counter3 = 30000;
        int counter4 = 40000;
        Hierarchy<Integer> hierarchy = new Hierarchy<>(-2);

        hierarchy.add(-2, 10000);
        hierarchy.add(-2, 20000);
        hierarchy.add(-2, 30000);
        hierarchy.add(-2, 40000);
        for (int i = 1; i < 10000; i++)
        {
            hierarchy.add(counter1, --counter1);
            hierarchy.add(counter2, --counter2);
            hierarchy.add(counter3, --counter3);
            hierarchy.add(counter4, --counter4);
        }

        int count = 40001;
        counter1 = 9000;
        counter2 = 18000;
        counter3 = 27000;
        counter4 = 36000;
        long start = System.currentTimeMillis();
        for (int i = 1; i < 5001; i++)
        {
            hierarchy.remove(counter1--);
            hierarchy.remove(counter2--);
            hierarchy.remove(counter3--);
            hierarchy.remove(counter4--);
            count -= 4;
            Assert.assertEquals("Count did not decrease correctly!", count, hierarchy.getCount());
        }

        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 200);

        Assert.assertEquals("Incorrect count after removal!", 20001, hierarchy.getCount());
        counter1 = 9000;
        counter2 = 18000;
        counter3 = 27000;
        counter4 = 36000;
        for (int i = 0; i < 5000; i++)
        {
            Assert.assertFalse(hierarchy.contains(counter1--));
            Assert.assertFalse(hierarchy.contains(counter2--));
            Assert.assertFalse(hierarchy.contains(counter3--));
            Assert.assertFalse(hierarchy.contains(counter4--));
        }

        Assert.assertTrue(hierarchy.contains(-2));
        Assert.assertEquals(Arrays.asList(4000), IterableExtensions.toList(hierarchy.getChildren(9001)));
        Assert.assertEquals(Arrays.asList(13000), IterableExtensions.toList(hierarchy.getChildren(18001)));
        Assert.assertEquals(Arrays.asList(22000), IterableExtensions.toList(hierarchy.getChildren(27001)));
        Assert.assertEquals(Arrays.asList(31000), IterableExtensions.toList(hierarchy.getChildren(36001)));
    }
}
