package reactor;

public class Heavy extends ReactorImpl {

    public Heavy(String name, int capacity, int memory) {

        super(name, increaseCapacity(capacity), decreaseMemory(memory));
    }

    private static int increaseCapacity(int capacity) {
        // doubles capacity
        return capacity * 2;
    }

    private static int decreaseMemory(int memory) {
        // decreases Memory by 25%
        return memory - (memory / 4);
    }
}