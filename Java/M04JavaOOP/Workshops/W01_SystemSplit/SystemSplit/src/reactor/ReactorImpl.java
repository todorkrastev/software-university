package reactor;

import interfaces.Reactor;
import software.SoftwareImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ReactorImpl implements Reactor {

    private final String name;
    private final int maximumCapacity;
    private final int maximumMemory;
    private final List<SoftwareImpl> softwareList;

    public ReactorImpl(String name, int maximumCapacity, int maximumMemory) {
        this.name = name;
        this.maximumCapacity = maximumCapacity;
        this.maximumMemory = maximumMemory;
        this.softwareList = new LinkedList<>();
    }

    @Override
    public List<SoftwareImpl> getSoftware() {

        return this.softwareList;
    }

    @Override
    public void add(SoftwareImpl software) {

        this.softwareList.add(software);
    }

    @Override
    public void remove(SoftwareImpl software) {

        this.softwareList.remove(software);
    }

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public int getMaximumCapacity() {

        return this.maximumCapacity;
    }

    @Override
    public int getMaximumMemory() {

        return this.maximumMemory;
    }

    public int countOfExpressSoftwareComponents() {

        return (int) this.getSoftware().stream().filter(s -> s.getClass().getSimpleName().equals("Express")).count();
    }

    public int countOfLightSoftwareComponents() {

        return (int) this.getSoftware().stream().filter(s -> s.getClass().getSimpleName().equals("Light")).count();
    }

    @Override
    public  int memoryUsed(){

        return this.getSoftware().stream().mapToInt(SoftwareImpl::getMemoryConsumption).sum();
    }
    @Override
    public int capacityUsed(){

        return this.getSoftware().stream().mapToInt(SoftwareImpl::getCapacityConsumption).sum();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(String.format("Hardware Component - %s",this.getName()))
                .append(System.lineSeparator())
                .append(String.format("Express Software Components - %d",countOfExpressSoftwareComponents()))
                .append(System.lineSeparator())
                .append(String.format("Light Software Components - %d",countOfLightSoftwareComponents()))
                .append(System.lineSeparator())
                .append(String.format("Memory Usage: %d / %d",memoryUsed(),this.maximumMemory))
                .append(System.lineSeparator())
                .append(String.format("Capacity Usage: %d / %d",capacityUsed(),this.maximumCapacity))
                .append(System.lineSeparator())
                .append(String.format("Type: %s",this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Software Components: ");

            output.append(this.getSoftware().isEmpty()
                    ? "None"
                    : this.softwareList.stream().map(SoftwareImpl::getName).collect(Collectors.joining(", ")));

        return output.toString();
    }
}
