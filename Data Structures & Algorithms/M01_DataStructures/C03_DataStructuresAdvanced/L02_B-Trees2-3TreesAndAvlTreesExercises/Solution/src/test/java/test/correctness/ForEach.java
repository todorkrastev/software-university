package test.correctness;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.helpers.BaseTest;
import test.types.CorrectnessTests;

public class ForEach extends BaseTest {

    @Category(CorrectnessTests.class)
    @Test
    public void ForEach_WithOnlyRoot_ShouldIterateOnlyThroughRoot()
    {
        int count = 0;
        int[] collection = new int[] { DefaultRootValue };
        for (int element : this.Hierarchy)
        {
            Assert.assertEquals(collection[count++], element);
        }
    }

    @Category(CorrectnessTests.class)
    @Test
    public void ForEach_WithMultipleElements_ShouldIterateOverCollectionOnlyOnce()
    {
        int count = 0;
        this.Hierarchy.add(DefaultRootValue, 50);
        this.Hierarchy.add(DefaultRootValue, 70);
        this.Hierarchy.add(70, 100);
        this.Hierarchy.add(50, 200);
        this.Hierarchy.add(70, 120);
        this.Hierarchy.add(70, 110);
        this.Hierarchy.add(110, 0);
        this.Hierarchy.add(200, 201);
        this.Hierarchy.add(201, 202);
        this.Hierarchy.add(50, 300);
        int[] collection = new int[] { DefaultRootValue, 50, 70, 200, 300, 100, 120, 110, 201, 0, 202 };

        for (int element : this.Hierarchy)
        {
            Assert.assertEquals(collection[count++], element);
        }

        Assert.assertEquals(count, this.Hierarchy.getCount());
    }

    @Category(CorrectnessTests.class)
    @Test
    public void ForEach_WithMultipleElements_ShouldIterateThroughThemInCorrectOrder()
    {
        this.Hierarchy.add(DefaultRootValue, -10);
        this.Hierarchy.add(DefaultRootValue, 10);
        this.Hierarchy.add(-10, -11);
        this.Hierarchy.add(-10, -12);
        this.Hierarchy.add(10, 11);
        this.Hierarchy.add(10, 12);
        this.Hierarchy.add(-11, -13);
        this.Hierarchy.add(-11, -14);
        this.Hierarchy.add(-12, -15);
        this.Hierarchy.add(-12, -16);
        this.Hierarchy.add(11, 13);
        int count = 0;
        int[] collection = new int[] { DefaultRootValue, -10, 10, -11, -12, 11, 12, -13, -14, -15, -16, 13 };
        for (int element : this.Hierarchy)
        {
            Assert.assertEquals(collection[count++], element);
        }
    }
}
