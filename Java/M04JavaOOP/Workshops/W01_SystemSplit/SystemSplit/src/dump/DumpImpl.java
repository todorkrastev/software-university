package dump;

import interfaces.Dump;
import interfaces.Reactor;
import software.SoftwareImpl;

import java.util.HashMap;
import java.util.Map;

public class DumpImpl implements Dump {

    private final Map<String, Reactor> dumpRepository;

    public DumpImpl() {
        this.dumpRepository = new HashMap<>();
    }

    @Override
    public Map<String, Reactor> getDumpRepository() {
        return dumpRepository;
    }

    @Override
    public void dump(String reactorName,Reactor reactor) {
        this.dumpRepository.put(reactorName,reactor);
    }

    @Override
    public Reactor restore(String reactorName) {
        return this.dumpRepository.remove(reactorName);

    }

    @Override
    public void destroy(String reactorName) {
        this.dumpRepository.remove(reactorName);
    }

    @Override
    public String analyze() {

        StringBuilder output = new StringBuilder();

        output.append("Dump Analysis")
                .append(System.lineSeparator())
                .append("Power Hardware Components: ")
                .append(totalPowerComponents())
                .append(System.lineSeparator())
                .append("Heavy Hardware Components: ")
                .append(totalHeavyComponents())
                .append(System.lineSeparator())
                .append("Express Software Components: ")
                .append(totalExpressComponents())
                .append(System.lineSeparator())
                .append("Light Software Components: ")
                .append(totalLightComponents())
                .append(System.lineSeparator())
                .append("Total Dumped Memory: ")
                .append(totalDumpedMemory())
                .append(System.lineSeparator())
                .append("Total Dumped Capacity: ")
                .append(totalDumpedCapacity());

        return output.toString();
    }

    private long totalDumpedCapacity() {
        return this.dumpRepository.values().stream().mapToInt(r->r.getSoftware().stream()
                .mapToInt(SoftwareImpl::getCapacityConsumption).sum()).sum();
    }

    private long totalDumpedMemory() {
        return this.dumpRepository.values().stream().mapToInt(r->r.getSoftware().stream()
                .mapToInt(SoftwareImpl::getMemoryConsumption).sum()).sum();
    }

    private long totalLightComponents() {
        return this.dumpRepository.values().stream().mapToInt(r-> (int) r.getSoftware().stream()
                .filter(s->s.getClass().getSimpleName().equals("Light")).count()).sum();
    }

    private long totalExpressComponents() {
        return this.dumpRepository.values().stream().mapToInt(r-> (int) r.getSoftware().stream()
                .filter(s->s.getClass().getSimpleName().equals("Express")).count()).sum();
    }

    private long totalHeavyComponents() {
        return this.dumpRepository.values().stream()
                .filter(r->r.getClass().getSimpleName().equals("Heavy")).count();
    }

    private long totalPowerComponents() {
        return  this.dumpRepository.values().stream()
                .filter(r->r.getClass().getSimpleName().equals("Power")).count();
    }

}
