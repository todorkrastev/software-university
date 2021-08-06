package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

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
        return 0 < this.getHealth();
    }

    @Override
    public void takeDamage(int points) {
        int decreaseHealth = points > this.getArmor() ? points - this.getArmor() : 0;
        this.setArmor(Math.max(this.getArmor() - points, 0));
        this.setHealth(Math.max(this.getHealth() - decreaseHealth, 0));
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();

        output.append(String.format("%s: %s", this.getClass().getSimpleName(), this.getUsername()))
                .append(System.lineSeparator())
                .append("--Health: ").append(this.getHealth())
                .append(System.lineSeparator())
                .append("--Armor: ").append(this.getArmor())
                .append(System.lineSeparator())
                .append("--Gun: ").append(this.getGun().getName());

        return output.toString().trim();
    }
}
