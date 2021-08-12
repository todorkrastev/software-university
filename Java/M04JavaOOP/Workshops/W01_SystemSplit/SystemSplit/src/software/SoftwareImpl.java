package software;

import interfaces.Software;

public abstract class SoftwareImpl implements Software {

    private final String name;
    private final int capacityConsumption;
    private final int memoryConsumption;

    public SoftwareImpl(String name, int capacityConsumption, int memoryConsumption) {

        this.name = name;
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    @Override
    public int getMemoryConsumption() {
        return memoryConsumption;
    }

}
