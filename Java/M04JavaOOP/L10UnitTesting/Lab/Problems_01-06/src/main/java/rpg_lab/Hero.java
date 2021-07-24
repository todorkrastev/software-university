package rpg_lab;

import java.util.Random;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;

    public Hero(String name, Weapon axe) {
        this.name = name;
        this.experience = 0;
        this.weapon = axe;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
        }
    }
}
