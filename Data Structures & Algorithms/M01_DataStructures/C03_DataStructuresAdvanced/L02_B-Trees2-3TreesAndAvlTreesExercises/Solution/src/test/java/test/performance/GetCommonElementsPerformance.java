package test.performance;

import main.Hierarchy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.helpers.BasePerformanceTest;
import test.helpers.IterableExtensions;
import test.types.PerformanceTests;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetCommonElementsPerformance extends BasePerformanceTest {

    @Category(PerformanceTests.class)
    @Test
    public void PerformanceGetCommonElements_WithNoCommonElements()
    {
        int start1 = 0;
        int start2 = 100000;
        Hierarchy<Integer> hierarchy = new Hierarchy<>(start1);
        Hierarchy<Integer> hierarchy2 = new Hierarchy<>(start2);

        for (int i = 1; i <= 50000; i++)
        {
            hierarchy.add(start1, i);
            hierarchy2.add(start2, start2 + i);
        }

        long start = System.currentTimeMillis();
        long count = IterableExtensions.getCount(hierarchy.getCommonElements(hierarchy2));
        Assert.assertEquals(0, count);

        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 200);
    }

    @Category(PerformanceTests.class)
    @Test
    public void PerformanceGetCommonElements_WithHalfCommonElementsInBothCollections()
    {
        int start1 = 0;
        int start2 = 75000;
        Hierarchy<Integer> hierarchy = new Hierarchy<>(start1);
        Hierarchy<Integer> hierarchy2 = new Hierarchy<>(start2);

        for (int i = 1; i <= 50000; i++)
        {
            hierarchy.add(start1, i);
        }

        for (int i = start2 - 1; i > 25000; i--)
        {
            hierarchy2.add(start2, i);
        }

        List<Integer> expectedCommon = IntStream.range(25001, 25001 + 25000).boxed().collect(Collectors.toList());
        long start = System.currentTimeMillis();

        List<Integer> actualCommon = IterableExtensions.toList(hierarchy.getCommonElements(hierarchy2));
        Assert.assertEquals(expectedCommon, actualCommon);

        long end = System.currentTimeMillis();
        Assert.assertTrue(end - start < 200);
    }
}
