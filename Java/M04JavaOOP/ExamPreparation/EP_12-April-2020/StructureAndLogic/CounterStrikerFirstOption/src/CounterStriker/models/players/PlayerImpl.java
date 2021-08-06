package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private Gun gun;
    private boolean isAlive;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        setUsername(username);
        setHealth(health);
        setArmor(armor);
        setGun(gun);
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

 /*   private void setAlive(int health) {
        if (health < 0) {
            this.isAlive = false;
        }
        this.isAlive = true;
    } */

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void takeDamage(int points) {
        // second option
        // int directDamage = points > this.armor ? points - this.armor : 0;
        // this.setArmor(Math.max(this.armor - points, 0));
        // this.setHealth(Math.max(this.health - directDamage, 0));

        int damage = points;
        if (this.getArmor() <= damage) {
            damage -= this.getArmor();
            this.armor = 0;
            this.health -= damage;
        } else {
            this.armor -= damage;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output
                .append(String.format("%s: %s", this.getClass().getSimpleName(), this.getUsername()))
                .append(System.lineSeparator())
                .append(String.format("--Health: %d", this.getHealth()))
                .append(System.lineSeparator())
                .append(String.format("--Armor: %d", this.getArmor()))
                .append(System.lineSeparator())
                .append(String.format("--Gun: %s", this.gun.getName()));

        return output.toString().trim();
    }
}
