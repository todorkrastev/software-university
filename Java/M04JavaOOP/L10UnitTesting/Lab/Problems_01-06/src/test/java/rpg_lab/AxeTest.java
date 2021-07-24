package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int ATTACK = 10;
    private static final int DURABILITY = 20;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = createAxe(DURABILITY);
        this.dummy = createDummy();
    }

    @Test
    public void testConstructorShouldSetAttackAndDurability() {
        assertEquals(ATTACK, axe.getAttackPoints());
        assertEquals(DURABILITY, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAxeAttackShouldFailIfAxeHasZeroDurability() {
        Axe axe = createAxe(0);
        axe.attack(dummy);
    }

    @Test
    public void testAxeMustLoosesSingleDurabilityPointWhenAttackDummy() {
        axe.attack(dummy);
        assertEquals(DURABILITY - 1, axe.getDurabilityPoints());
    }

    private Axe createAxe(int durability) {
        return new Axe(ATTACK, durability);
    }

    private Dummy createDummy() {
        return new Dummy(100, 100);
    }
}