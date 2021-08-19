package CounterStriker.models.guns;

import java.time.Period;

public class Pistol extends GunImpl {
    private static final int BULLETS_PER_SHOT = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (BULLETS_PER_SHOT <= this.getBulletsCount()) {
            this.setBulletsCount(this.getBulletsCount() - BULLETS_PER_SHOT);
            return BULLETS_PER_SHOT;
        }
        return super.fire();
    }
}
