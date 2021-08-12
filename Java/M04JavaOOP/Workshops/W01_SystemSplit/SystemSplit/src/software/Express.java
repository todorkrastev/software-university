package software;

public class Express extends SoftwareImpl {

    public Express(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, increaseMemoryConsumption(memoryConsumption));
    }

    private static int increaseMemoryConsumption(int memoryConsumption) {
        // doubles capacityConsumption
        return memoryConsumption * 2;
    }
}
