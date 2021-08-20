package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double INITIAL_UNITS_OF_OXYGEN = 70;
    private static final double DECREASE_OXYGEN_BY_FIVE_UNITS = 5;

    public Biologist(String name) {
        super(name, INITIAL_UNITS_OF_OXYGEN);
    }

    @Override
    public void breath() {
        if (this.canBreath()) {
            this.setOxygen(this.getOxygen() - DECREASE_OXYGEN_BY_FIVE_UNITS);
        }
    }
}
