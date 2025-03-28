package test.correctness;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.helpers.BaseTest;
import test.helpers.IterableExtensions;
import test.types.CorrectnessTests;

import java.util.Arrays;
import java.util.List;


public class GetChildren extends BaseTest {

    @Category(CorrectnessTests.class)
    @Test(expected = IllegalArgumentException.class)
    public void GetChildren_WithNonExistantElement_ShouldThrowException()
    {
        this.Hierarchy.getParent(-17);
    }

    @Category(CorrectnessTests.class)
    @Test
    public void GetChildren_WithAnElementWithNoChildren_ShouldReturnEmptyCollection()
    {
        this.Hierarchy.add(DefaultRootValue, 13);
        this.Hierarchy.add(DefaultRootValue, 14);
        this.Hierarchy.add(13, 17);
        this.Hierarchy.add(13, -666);

        Iterable<Integer> children = this.Hierarchy.getChildren(-666);

        Assert.assertEquals(0, IterableExtensions.getCount(children));
    }

    @Category(CorrectnessTests.class)
    @Test
    public void GetChildren_WithAnElementWithOneChild_ShouldReturnACollectionWithOneElement()
    {
        this.Hierarchy.add(DefaultRootValue, 55);
        this.Hierarchy.add(DefaultRootValue, 10);
        this.Hierarchy.add(55, 17);
        this.Hierarchy.add(55, 18);
        this.Hierarchy.add(10, -666);

        Iterable<Integer> children = this.Hierarchy.getChildren(10);
        List<Integer> result = IterableExtensions.toList(children);

        Assert.assertTrue(result.equals(Arrays.asList(-666)));
    }

    @Category(CorrectnessTests.class)
    @Test
    public void GetChildren_WithAnElementWithMultipleChildren_ShouldReturnACorrectCollection()
    {
        this.Hierarchy.add(DefaultRootValue, 25);
        this.Hierarchy.add(DefaultRootValue, 110);
        this.Hierarchy.add(25, -10);
        this.Hierarchy.add(110, 22);
        this.Hierarchy.add(110, 333);
        this.Hierarchy.add(110, 15);
        this.Hierarchy.add(110, 99);
        this.Hierarchy.add(99, 1);

        Iterable<Integer> children = this.Hierarchy.getChildren(110);
        List<Integer> result = IterableExtensions.toList(children);

        Assert.assertTrue(result.equals(Arrays.asList(22, 333, 15, 99)));
    }
}
