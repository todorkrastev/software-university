package test.performance;

import main.Hierarchy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.helpers.BasePerformanceTest;
import test.helpers.IterableExtensions;
import test.types.PerformanceTests;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetChildrenPerformance extends BasePerformanceTest {

    @Category(PerformanceTests.class)
    @Test
    public void PerformanceGetChildren_With1ElementWith50000ChildrenInReversedOrder()
    {
        Hierarchy<Integer> hierarchy = new Hierarchy<>(-17);

        for (int i = 50000; i > 0; i--)
        {
            hierarchy.add(-17, i);
        }

        List<Integer> expectedChildren = IntStream.range(1, 50000 + 1).boxed().collect(Collectors.toList());
        Collections.reverse(expectedChildren);
        long start = System.currentTimeMillis();
        List<Integer> actualChildren = IterableExtensions.toList(hierarchy.getChildren(-17));

        Assert.assertEquals(expectedChildren, actualChildren);
        long end = System.currentTimeMillis();

        Assert.assertTrue(end - start < 200);
    }

    @Category(PerformanceTests.class)
    @Test
    public void PerformanceGetChildren_With50000ElementsWith5000Parents()
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

        List<Integer> expectedChildren = IntStream.range(1, 5000 + 1).boxed().collect(Collectors.toList());
        counter = 5001;
        long start = System.currentTimeMillis();

        for (int i = 1; i <= 5000; i++)
        {
            Iterable<Integer> children = hierarchy.getChildren(i);
            int count = 0;
            for (int child : children)
            {
                count++;
                Assert.assertEquals(counter++, child);
            }

            Assert.assertEquals(10, count);
        }

        List<Integer> actualChildren = IterableExtensions.toList(hierarchy.getChildren(-88));
        Assert.assertEquals(expectedChildren, actualChildren);

        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 50);
    }
}
