package CounterStriker.models.guns;

public class Rifle extends GunImpl {

    private static final int SHOOTING_BULLETS_AT_ONCE = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < SHOOTING_BULLETS_AT_ONCE) {
            return 0;
        }
        super.decreaseBullets(SHOOTING_BULLETS_AT_ONCE);

        return SHOOTING_BULLETS_AT_ONCE;
    }
}
