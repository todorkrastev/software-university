package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {

    // by using dependencyInjection
    @Test
    public void testHeroGainsExperienceWhenTargetIsKilled() {

        Hero hero = new Hero("Awitochol", new TestWeapon());
        hero.attack(new TestTarget());
        assertEquals(20, hero.getExperience());

    }

    // by using mocking
    @Test
    public void testTwoForHeroGainsExperienceWhenTargetIsKilled(){

        Weapon weapon = mock(Weapon.class);
        Hero hero = new Hero("Awitochol", weapon);
        Target target = mock(Target.class);
        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(20);
        hero.attack(target);
        assertEquals(20, hero.getExperience());
    }

    private static class TestTarget implements Target{

        @Override
        public int getHealth() {
            return 0;
        }

        @Override
        public void takeAttack(int attackPoints) {

        }

        @Override
        public int giveExperience() {
            return 20;
        }

        @Override
        public boolean isDead() {
            return true;
        }
    }

    private static class TestWeapon implements Weapon{

        @Override
        public int getAttackPoints() {
            return 0;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Target target) {
        }
    }
}