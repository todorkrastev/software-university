package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int HEALTH = 10;
    private static final int EXPERIENCE = 20;
    private static final int ATTACK_POINTS = 5;

    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        aliveDummy = createDummy(HEALTH, EXPERIENCE);
        deadDummy = createDummy(0,EXPERIENCE);
    }

    @Test
    public void testDummyLosesHealthWhenIsAttacked() {
        aliveDummy.takeAttack(ATTACK_POINTS);
        assertEquals(HEALTH - ATTACK_POINTS, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyFailsWhenIsAttacked() {

        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyCanGiveExperience(){

        assertEquals(EXPERIENCE,deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyDoesntGiveExperience(){

        aliveDummy.giveExperience();
    }

    public Dummy createDummy(int health, int experience) {

        return new Dummy(health, experience);
    }
}
