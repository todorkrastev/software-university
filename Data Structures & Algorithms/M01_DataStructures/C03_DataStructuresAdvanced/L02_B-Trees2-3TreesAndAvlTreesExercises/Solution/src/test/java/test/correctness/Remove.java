package test.correctness;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.helpers.BaseTest;
import test.helpers.IterableExtensions;
import test.types.CorrectnessTests;

import java.util.Arrays;
import java.util.List;

public class Remove extends BaseTest {

    @Category(CorrectnessTests.class)
    @Test(expected = IllegalArgumentException.class)
    public void Remove_WithNonExistantElement_ShouldThrowException()
    {
        int nonExistingElement = 7;
        this.Hierarchy.remove(nonExistingElement);
    }

    @Category(CorrectnessTests.class)
    @Test(expected = IllegalStateException.class)
    public void Remove_WithRootElement_ShouldThrowException()
    {
        this.Hierarchy.remove(DefaultRootValue);
    }

    @Category(CorrectnessTests.class)
    @Test
    public void Remove_WithOneElement_ShouldDecreaseCountByOne()
    {
        this.Hierarchy.add(DefaultRootValue, 2);

        this.Hierarchy.remove(2);

        Assert.assertEquals(1, this.Hierarchy.getCount());
    }

    @Category(CorrectnessTests.class)
    @Test
    public void Remove_WithElementWithChildren_ShouldDecreaseCountCorrectly()
    {
        this.Hierarchy.add(DefaultRootValue, 10);
        this.Hierarchy.add(DefaultRootValue, 11);
        this.Hierarchy.add(10, 12);
        this.Hierarchy.add(10, 13);
        this.Hierarchy.add(11, 14);
        Assert.assertEquals(6, this.Hierarchy.getCount());

        this.Hierarchy.remove(10);

        Assert.assertEquals(5, this.Hierarchy.getCount());
    }

    @Category(CorrectnessTests.class)
    @Test
    public void Remove_WithElementWithNoChildren_ShouldRemoveElementCorrectly()
    {
        this.Hierarchy.add(DefaultRootValue, 2);
        this.Hierarchy.add(2, 3);

        this.Hierarchy.remove(3);

        Assert.assertFalse(this.Hierarchy.contains(3));
        Assert.assertFalse(IterableExtensions.contains(this.Hierarchy.getChildren(2), 3));
    }

    @Category(CorrectnessTests.class)
    @Test
    public void Remove_WithElementWithChildren_ShouldAttachChildrenToRemovedElementsParent()
    {
        this.Hierarchy.add(DefaultRootValue, 10);
        this.Hierarchy.add(DefaultRootValue, 11);
        this.Hierarchy.add(10, 12);
        this.Hierarchy.add(10, 13);
        this.Hierarchy.add(11, 14);

        this.Hierarchy.remove(10);

        Assert.assertEquals(DefaultRootValue, (int)this.Hierarchy.getParent(12));
        Assert.assertEquals(DefaultRootValue, (int)this.Hierarchy.getParent(13));

        Iterable<Integer> rootChildren = this.Hierarchy.getChildren(DefaultRootValue);
        List<Integer> result = IterableExtensions.toList(rootChildren);
        Assert.assertTrue(result.equals(Arrays.asList(11, 12, 13)));
    }
}
