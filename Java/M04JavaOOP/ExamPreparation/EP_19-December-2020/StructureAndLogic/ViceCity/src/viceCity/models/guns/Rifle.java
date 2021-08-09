package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int DEFAULT_BULLETS_PER_BARREL = 50;
    private static final int DEFAULT_TOTAL_BULLETS = 500;

    public Rifle(String name) {
        super(name, DEFAULT_BULLETS_PER_BARREL, DEFAULT_TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        this.setTotalBullets(this.getTotalBullets() - 5);
        return 5;
    }
}
