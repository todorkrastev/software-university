package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private static final double ENERGY = 60;
    private static final double DECREASE_ENERGY_WITH_7_UNITS = 7;

    public NaturalExplorer(String name) {
        super(name, ENERGY);
    }

    @Override
    public void search() {
        this.setEnergy(Math.max(this.getEnergy() - DECREASE_ENERGY_WITH_7_UNITS, 0));
    }
}
