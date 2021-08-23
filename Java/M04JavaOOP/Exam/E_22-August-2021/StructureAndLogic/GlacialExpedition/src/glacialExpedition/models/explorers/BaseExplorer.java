package glacialExpedition.models.explorers;

import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer {
    private String name;
    private double energy;
    private Suitcase suitcase;
    private static final double DECREASE_ENERGY_WITH_15_UNITS = 15;

    protected BaseExplorer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.setSuitcase();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    private void setSuitcase() {
        this.suitcase = new Carton();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return 0 < this.getEnergy();
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        this.setEnergy(Math.max(this.getEnergy() - DECREASE_ENERGY_WITH_15_UNITS, 0));
    }
}
