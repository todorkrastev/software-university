package test.correctness;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import test.helpers.BaseTest;
import test.types.CorrectnessTests;

public class Contains extends BaseTest {

    @Category(CorrectnessTests.class)
    @Test
    public void Contains_WithANonExistantElement_ShouldReturnFalse()
    {
        boolean result = this.Hierarchy.contains(1);

        Assert.assertFalse(result);
    }

    @Category(CorrectnessTests.class)
    @Test
    public void Contains_WithASingleElement_ShouldReturnTrue()
    {
        boolean result = this.Hierarchy.contains(DefaultRootValue);

        Assert.assertTrue(result);
    }

    @Category(CorrectnessTests.class)
    @Test
    public void Contains_WithMultipleSearchesForASingleElement_ShouldReturnConsistentResult()
    {
        this.Hierarchy.add(DefaultRootValue, 666);

        for (int i = 0; i < 4; i++) {
            Assert.assertTrue(this.Hierarchy.contains(666));
        }
    }

    @Category(CorrectnessTests.class)
    @Test
    public void Contains_WithBothExistingAndNonexsitantElements_ShouldReturnCorrectResults()
    {
        this.Hierarchy.add(DefaultRootValue, 666);
        this.Hierarchy.add(666, 6666);
        this.Hierarchy.add(6666, 66666);

        Assert.assertTrue(this.Hierarchy.contains(666));
        Assert.assertFalse(this.Hierarchy.contains(667));
        Assert.assertTrue(this.Hierarchy.contains(6666));
        Assert.assertFalse(this.Hierarchy.contains(6665));
        Assert.assertFalse(this.Hierarchy.contains(-17000));
        Assert.assertTrue(this.Hierarchy.contains(66666));
    }

    @Category(CorrectnessTests.class)
    @Test
    public void Contains_WithAnExistingElementWithMultipleElements_ShouldReturnTrue()
    {
        this.Hierarchy.add(DefaultRootValue, 2);
        this.Hierarchy.add(DefaultRootValue, 3);
        this.Hierarchy.add(2, 4);
        this.Hierarchy.add(3, 6);
        this.Hierarchy.add(4, 7);

        boolean result = this.Hierarchy.contains(6);

        Assert.assertTrue(result);
    }
}
