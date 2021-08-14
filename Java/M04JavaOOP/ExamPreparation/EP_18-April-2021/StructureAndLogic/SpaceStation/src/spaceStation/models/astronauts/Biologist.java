package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private static final double INITIAL_OXYGEN = 70;
    private static final double DECREASE_OXYGEN_WITH_FIVE_UNITS = 5;
    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        super.setOxygen(super.getOxygen() - DECREASE_OXYGEN_WITH_FIVE_UNITS);
    }
}
