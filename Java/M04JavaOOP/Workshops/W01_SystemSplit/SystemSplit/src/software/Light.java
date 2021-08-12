package software;

public class Light extends SoftwareImpl {

    public Light(String name, int capacityConsumption, int memoryConsumption) {
        super(name, increaseCapacityConsumption(capacityConsumption), decreaseMemoryConsumption(memoryConsumption));
    }

    private static int increaseCapacityConsumption(int capacityConsumption) {
        // increases capacityConsumption by 50%
        return capacityConsumption + (capacityConsumption / 2);
    }

    private static int decreaseMemoryConsumption(int memoryConsumption) {
        // decreases memoryConsumption by 50%
        return memoryConsumption - (memoryConsumption / 2);
    }
}
