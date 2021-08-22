package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    private Farm farm;
    private Animal animal1;
    private Animal animal2;

    @Before
    public void setUp() {
        this.farm = new Farm("Infinity", 2);
        this.animal1 = new Animal("Dog", 19);
        this.animal2 = new Animal("Cat", 23);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, this.farm.getCount());
        this.farm.add(this.animal1);
        this.farm.add(this.animal2);
        Assert.assertEquals(2, this.farm.getCount());
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Infinity", this.farm.getName());
    }

    @Test
    public void testGetCapacity() {
        Assert.assertEquals(2, this.farm.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsExceptionWhenThereIsNotEnoughCapacity() {
        this.farm.add(this.animal1);
        this.farm.add(this.animal2);
        this.farm.add(new Animal("Horse", 92));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTwiceExistingAnimalThrowsException() {
        this.farm.add(this.animal1);
        this.farm.add(this.animal1);
    }

    @Test
    public void testRemoveReturnsTrueOrFalse() {
        this.farm.add(this.animal1);
        Assert.assertTrue(this.farm.remove(this.animal1.getType()));
        Assert.assertFalse(this.farm.remove(this.animal1.getType()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeCapacityThrowsException() {
        Farm farm = new Farm("Awitohol", -2);
    }

    @Test(expected = NullPointerException.class)
    public void testNullNameThrowsException() {
        Farm farm = new Farm(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyStringNameThrowsException() {
        Farm farm = new Farm("    ", 2);
    }

    @Test
    public void testGetEnergy() {
        Assert.assertEquals(19, this.animal1.getEnergy(), 0.0);
    }
}
