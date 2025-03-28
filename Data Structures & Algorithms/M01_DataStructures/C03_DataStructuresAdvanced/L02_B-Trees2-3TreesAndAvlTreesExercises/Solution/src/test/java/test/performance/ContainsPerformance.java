package test.performance;

import main.Hierarchy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.helpers.BasePerformanceTest;
import test.types.PerformanceTests;

public class ContainsPerformance extends BasePerformanceTest {

    @Category(PerformanceTests.class)
    @Test
    public void PerformanceContains_With50000LookUpsInReversedOrderWith50000ElementsWith1Parent()
    {
        Hierarchy<Integer> hierarchy = new Hierarchy<>(-3);

        for (int i = 1; i < 50001; i++)
        {
            hierarchy.add(-3, i);
        }

        long start = System.currentTimeMillis();
        for (int i = 50000; i > 0; i--)
        {
            Assert.assertTrue("Contains method returned wrong value!", hierarchy.contains(i));
        }

        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 50);
    }

    @Category(PerformanceTests.class)
    @Test
    public void PerformanceContains_With25000ExistingAnd25000NonexistantElements()
    {
        Hierarchy<Integer> hierarchy = new Hierarchy<>(-1);

        for (int i = 1; i < 50001; i = i + 2)
        {
            hierarchy.add(i - 2, i);
        }

        long start = System.currentTimeMillis();

        for (int i = 1; i < 50001; i = i + 2)
        {
            Assert.assertTrue("Contains method returned wrong value!", hierarchy.contains(i));
            Assert.assertFalse("Contains method returned wrong value!", hierarchy.contains(i + 1));
        }

        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 50);
    }
}
