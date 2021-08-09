package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {

    private static final String TEST_NAME = "test";
    private static final int TEST_CAPACITY = 2;
    private static final String TEST_NAME_BY_ASTRONAUT_1 = "Ivanov";
    private static final String TEST_NAME_BY_ASTRONAUT_2 = "Gagarin";
    private static final double TEST_OXYGEN_BY_ASTRONAUT_1 = 88.8;
    private static final double TEST_OXYGEN_BY_ASTRONAUT_2 = 77.7;

    private static Spaceship spaceship;
    private static Astronaut astronaut1;
    private static Astronaut astronaut2;

    @Before
    public void setUp() {
        astronaut1 = createAstronaut(TEST_NAME_BY_ASTRONAUT_1, TEST_OXYGEN_BY_ASTRONAUT_1);
        astronaut2 = createAstronaut(TEST_NAME_BY_ASTRONAUT_2, TEST_OXYGEN_BY_ASTRONAUT_2);
        spaceship = createSpaceship(TEST_NAME, TEST_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorMustFailsWhenGetCapacityLessThenZero() {

        spaceship = createSpaceship(TEST_NAME, -2);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorMustFailsWhenGetInvalidName() {

        spaceship = createSpaceship("", TEST_CAPACITY);
    }

    @Test
    public void testConstructorMustCreateObjectWhenParametersIsValid() {

        Assert.assertEquals(TEST_NAME, spaceship.getName());
        Assert.assertEquals(TEST_CAPACITY, spaceship.getCapacity());
    }

    @Test
    public void testAddAstronautWhitCorrectParameters() {

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        Assert.assertEquals(2, spaceship.getCount());
        Assert.assertEquals(TEST_NAME_BY_ASTRONAUT_1, astronaut1.getName());
        Assert.assertEquals(TEST_OXYGEN_BY_ASTRONAUT_1, astronaut1.getOxygenInPercentage(), 0.00);
        Assert.assertEquals(TEST_NAME_BY_ASTRONAUT_2, astronaut2.getName());
        Assert.assertEquals(TEST_OXYGEN_BY_ASTRONAUT_2, astronaut2.getOxygenInPercentage(), 0.00);
    }

    @Test
    public void testRemoveAstronautMustRemoveCorrectObjectAndReturnBoolean() {

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        Assert.assertTrue(spaceship.remove(TEST_NAME_BY_ASTRONAUT_1));
        Assert.assertFalse(spaceship.remove(TEST_NAME_BY_ASTRONAUT_1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautMustFailsWhenAddMoreThenCapacity() {

        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
        spaceship.add(createAstronaut("name", 44.4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAstronautMustFailsWhenTryToAddAstronautWhitExistingName() {

        spaceship.add(astronaut1);
        spaceship.add(astronaut1);
    }

    private static Spaceship createSpaceship(String name, int capacity) {
        return new Spaceship(name, capacity);
    }

    private static Astronaut createAstronaut(String name, double oxygen) {
        return new Astronaut(name, oxygen);
    }
}
