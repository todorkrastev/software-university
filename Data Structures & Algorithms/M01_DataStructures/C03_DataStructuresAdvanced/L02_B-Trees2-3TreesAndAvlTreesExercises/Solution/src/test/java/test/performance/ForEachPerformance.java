package test.performance;

import main.Hierarchy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.helpers.BasePerformanceTest;
import test.types.PerformanceTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForEachPerformance extends BasePerformanceTest {

    @Category(PerformanceTests.class)
    @Test
    public void PerformanceForEach_With55500Elements()
    {
        int start1 = 0;
        int start2 = 5000;
        int start3 = 100000;
        List<Integer> elements = new ArrayList<>();
        elements.add(start1);
        Hierarchy<Integer> hierarchy = new Hierarchy<>(start1);

        for (int i = 1; i <= 500; i++)
        {
            elements.add(i);
            hierarchy.add(start1, i);
            for (int j = 0; j < 10; j++)
            {
                elements.add(start2);
                hierarchy.add(i, start2);
                for (int k = 0; k < 10; k++)
                {
                    elements.add(start3);
                    hierarchy.add(start2, start3++);
                }
                start2++;
            }
        }

        Collections.sort(elements);

        int counter = 0;
        long start = System.currentTimeMillis();
        for (int element : hierarchy)
        {
            Assert.assertEquals("Expected element did not match!", (int)elements.get(counter++), element);
        }

        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 200);

        Assert.assertEquals(counter, hierarchy.getCount());
    }

    @Category(PerformanceTests.class)
    @Test
    public void PerformanceForEach_With55500ElementsInterconnected()
    {
        int start1 = 0;
        List<Integer> elements = new ArrayList<>();
        elements.add(start1);
        Hierarchy<Integer> hierarchy = new Hierarchy<>(start1);

        for (int i = 1; i <= 51100; i = i + 511)
        {
            hierarchy.add(start1, i);
            for (int j = i + 1; j <= i + 510; j = j + 51)
            {
                hierarchy.add(i, j);
                for (int k = j + 1; k <= j + 50; k++)
                {
                    hierarchy.add(j, k);
                }
            }
        }

        for (int i = 1; i <= 51100; i = i + 511)
        {
            elements.add(i);
        }

        for (int i = 1; i <= 51100; i = i + 511)
        {
            for (int j = i + 1; j <= i + 510; j = j + 51)
            {
                elements.add(j);
            }
        }

        for (int i = 1; i <= 51100; i = i + 511)
        {
            for (int j = i + 1; j <= i + 510; j = j + 51)
            {
                for (int k = j + 1; k <= j + 50; k++)
                {
                    elements.add(k);
                }
            }
        }

        int counter = 0;

        long start = System.currentTimeMillis();

        for (int element: hierarchy)
        {
            Assert.assertEquals((int)elements.get(counter++), element);
        }

        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 200);

        Assert.assertEquals(counter, hierarchy.getCount());
    }
}
