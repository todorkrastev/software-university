package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlayerTests {

    private static final String name1 = "AK47";
    private static final String name2 = "M16";
    private static final int bullets1 = 30;
    private static final int bullets2 = 20;
    private Gun gun1;
    private Gun gun2;
    private static final String username = "Todor";
    private static final int health = 100;
    private Player player;


    @Before
    public void setUp() {
        player = new Player(username, health);
        gun1 = new Gun(name1, bullets1);
        gun2 = new Gun(name2, bullets2);

    }

    @Test(expected = NullPointerException.class)
    public void testCreatePlayerMustFailsWhenNameIsNull() {
        player = new Player(null, health);
    }

    @Test(expected = NullPointerException.class)
    public void testCreatePlayerMustFailsWhenNameLengthIsLessThenOne() {
        player = new Player("", health);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatePlayerMustFailsWhenHealthIsLessThenZero() {
        player = new Player(username, -1);
    }

    @Test(expected = NullPointerException.class)
    public void testAddGunMustFailsWhenGunIsNull() {
        player.addGun(null);
    }

    @Test
    public void testCreatePlayerCorrect() {
        Assert.assertEquals(username, player.getUsername());
        Assert.assertEquals(health, player.getHealth());

    }

    @Test
    public void testRemoveGunShouldRemoveCorrect() {
        player.addGun(gun1);
        Assert.assertTrue(player.removeGun(gun1));
        Assert.assertFalse(player.removeGun(gun1));
    }

    @Test
    public void testGetGunShouldReturnCorrectGunByName() {
        player.addGun(gun1);
        player.addGun(gun2);
        Assert.assertEquals(name1, player.getGun(name1).getName());
        Assert.assertEquals(bullets1, player.getGun(name1).getBullets());

    }

    @Test
    public void testTakeDamageShouldTakeFromPlayerHealth() {
        player.takeDamage(5);
        Assert.assertEquals(health - 5, player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamagesMustFailIfHealthIsLessOrEqualsZero() {
        player.takeDamage(101);
        player.takeDamage(1);
    }

    @Test
    public void testGetGunsShouldReturnsAllGuns() {
        player.addGun(gun2);
        player.addGun(gun1);
        Assert.assertEquals(2, player.getGuns().size());
        List<Gun> gunList = player.getGuns();
        Assert.assertEquals(gun1, gunList.get(1));
        Assert.assertEquals(gun2, gunList.get(0));
    }
}