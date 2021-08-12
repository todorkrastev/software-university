package repository;

import interfaces.Reactor;
import interfaces.Repository;
import software.SoftwareImpl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class RepositoryImpl implements Repository {

    private final Map<String, Reactor> repository;

    public RepositoryImpl() {

        repository = new HashMap<>();
    }

    @Override
    public Map getRepository() {

        return repository;
    }

    @Override
    public void release(String hardware, String software) {
        if (repository.containsKey(hardware)) {
            repository.get(hardware).getSoftware()
                    .stream().filter(s -> s.getName().equals(software))
                    .findFirst().ifPresent(currentSoftware -> repository.get(hardware).remove(currentSoftware));
        }
    }

    @Override
    public String analyze() {

        return String.format("System Analysis%nHardware Components: %d%nSoftware Components: %d%n" +
                        "Total Operational Memory: %d / %d%nTotal Capacity Taken: %d / %d"
                , countOfHardwareComponents()
                , countOfSoftwareComponents()
                , totalOperationalMemoryInUse()
                , maximumMemory()
                , totalCapacityTaken(), maximumCapacity());
    }

    @Override
    public String finalizes() {
        StringBuilder output = new StringBuilder();
        repository.values().stream().sorted(Comparator.comparing(r -> r.getClass().getSimpleName()).reversed())
                .forEach(e -> output.append(e.toString()).append(System.lineSeparator()));
        return output.toString();
    }

    public int countOfHardwareComponents() {
        return repository.size();
    }

    public int countOfSoftwareComponents() {
        return repository.values().stream().mapToInt(r -> r.getSoftware().size()).sum();
    }

    public int maximumMemory() {
        return repository.values().stream().mapToInt(Reactor::getMaximumMemory).sum();
    }

    public int maximumCapacity() {
        return repository.values().stream().mapToInt(Reactor::getMaximumCapacity).sum();
    }

    public int totalOperationalMemoryInUse() {
        return repository.values().stream().mapToInt(r -> r.getSoftware().stream()
                .mapToInt(SoftwareImpl::getMemoryConsumption).sum()).sum();
    }

    public int totalCapacityTaken() {
        return repository.values().stream().mapToInt(r -> r.getSoftware().stream()
                .mapToInt(SoftwareImpl::getCapacityConsumption).sum()).sum();
    }

}
