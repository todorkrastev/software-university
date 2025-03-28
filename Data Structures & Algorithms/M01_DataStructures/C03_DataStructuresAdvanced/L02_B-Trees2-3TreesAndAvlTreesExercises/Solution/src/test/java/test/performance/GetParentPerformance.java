package test.performance;

import main.Hierarchy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.helpers.BasePerformanceTest;
import test.types.PerformanceTests;

public class GetParentPerformance extends BasePerformanceTest {

    @Category(PerformanceTests.class)
    @Test
    public void PerformanceGetParent_With50000ElementsWith1ParentInReversedOrder()
    {
        Hierarchy<Integer> hierarchy = new Hierarchy<>(0);

        for (int i = 1; i < 50001; i++)
        {
            hierarchy.add(0, i);
        }

        long start = System.currentTimeMillis();

        for (int i = 50000; i > 0; i--)
        {
            Assert.assertEquals(0, (int) hierarchy.getParent(i));
        }

        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 200);
    }

    @Category(PerformanceTests.class)
    @Test
    public void PerformanceGetParent_With50000ElementsWith5000Parents()
    {
        int counter = 5001;
        Hierarchy<Integer> hierarchy = new Hierarchy<>(-88);
        for (int i = 1; i <= 5000; i++)
        {
            hierarchy.add(-88, i);
            for (int j = 0; j < 10; j++)
            {
                hierarchy.add(i, counter++);
            }
        }

        counter = 5001;
        long start = System.currentTimeMillis();

        for (int i = 1; i <= 5000; i++)
        {
            Assert.assertEquals(-88, (int) hierarchy.getParent(i));
            for (int j = 0; j < 10; j++)
            {
                Assert.assertEquals(i, (int) hierarchy.getParent(counter++));
            }
        }

        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 200);
    }
}
