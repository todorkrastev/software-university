package reactor;

public class Power extends ReactorImpl {

    public Power(String name, int capacity, int memory) {
        super(name, decreaseCapacity(capacity), increaseMemory(memory));
    }

    private static int decreaseCapacity(int capacity) {
        //decreases capacity by 75%
        return capacity - ((capacity * 3) / 4);
    }

    private static int increaseMemory(int memory) {
        //increases memory by 75%
        return memory + ((memory * 3) / 4);
    }
}
