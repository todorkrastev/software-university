package heroRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTests {
    HeroRepository heroRepository;
    Hero hero1;
    Hero hero2;

    @Before
    public void SetUp() {
        heroRepository = new HeroRepository();
        hero1 = new Hero("Todor", 89);
        hero2 = new Hero("Dominique", 92);
    }

    @Test
    public void testGetCount() {
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        assertEquals(2, heroRepository.getCount());
    }

    @Test (expected = NullPointerException.class)
    public void testCreateWithNullHeroShouldThrowException() {
        heroRepository.create(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateHeroTwoTimesShouldThrowException() {
        heroRepository.create(hero1);
        heroRepository.create(hero1);
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveWithNullString() {
        heroRepository.create(hero1);
        heroRepository.remove(null);
    }

    @Test (expected = NullPointerException.class)
    public void testRemoveWithEmptyString() {
        heroRepository.create(hero1);
        heroRepository.remove("    ");
    }

    @Test
    public void testRemove() {
        heroRepository.create(hero1);
        assertTrue(heroRepository.remove(hero1.getName()));
        assertFalse(heroRepository.remove(hero1.getName()));
    }

    @Test
    public void testGetHeroWithHighestLevel() {
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        assertEquals(hero2, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelReturnsNull() {
        assertEquals(null, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHero() {
        heroRepository.create(hero1);
        assertEquals(hero1, heroRepository.getHero(hero1.getName()));
    }

    @Test
    public void testGetHeroReturnsNull() {
        assertEquals(null, heroRepository.getHero(hero1.getName()));
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetHeroes() {
        heroRepository.create(hero1);
        heroRepository.getHeroes().remove(hero1);
    }
}
