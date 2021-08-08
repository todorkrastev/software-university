package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {

    private static final String name1 = "Todor";
    private static final String name2 = "Dominique";
    private Fish fish1;
    private Fish fish2;
    private Aquarium aquarium;

    @Before
    public void set() {
        fish1 = new Fish(name1);
        fish2 = new Fish(name2);
        aquarium = new Aquarium("Infinity", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldFailWhenCapacityIsNotEnough() {
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.add(new Fish("nana"));
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNameIsNull() {
        Aquarium aquarium1 = new Aquarium(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldFailWhenNameIsEmptyString() {
        Aquarium aquarium1 = new Aquarium("    ", 2);
    }

    @Test
    public void testSetNameShouldReturnCorrectName() {
        Assert.assertEquals("Infinity", aquarium.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldFailWhenCapacityIsLessThenZero() {
        Aquarium aquarium1 = new Aquarium("Infinity", -1);
    }

    @Test
    public void testGetCountShouldReturnCorrectCountOfFishInCollection() {
        aquarium.add(fish1);
        aquarium.add(fish2);
        Assert.assertEquals(2, aquarium.getCount());
        Assert.assertEquals(2, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldFailWithNotExistingName() {
        aquarium.add(fish1);
        aquarium.remove(name1);
        aquarium.remove(name2);
    }

    @Test
    public void testReportShouldReturnCorrectReportOfFishInCollection() {
        aquarium.add(fish1);
        aquarium.add(fish2);
        String expected = "Fish available at Infinity: Todor, Dominique";
        Assert.assertEquals(expected, aquarium.report());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByNameShouldFailWithNotExistingName() {
        aquarium.add(fish1);
        Assert.assertEquals(fish1, aquarium.sellFish(name1));
        aquarium.sellFish(name2);
    }

    @Test
    public void testSellFishShouldSetFalseIfFishIsAlreadySold() {
        aquarium.add(fish1);
        Assert.assertFalse(aquarium.sellFish(name1).isAvailable());
    }
}
