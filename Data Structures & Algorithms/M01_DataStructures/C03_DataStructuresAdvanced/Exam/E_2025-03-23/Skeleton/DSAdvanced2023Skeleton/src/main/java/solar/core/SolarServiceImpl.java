package solar.core;

import solar.models.Inverter;
import solar.models.PVModule;

import java.util.*;
import java.util.stream.Collectors;

public class SolarServiceImpl implements SolarService {
    private final Set<PVModule> pvModules;
    private final Map<String, Inverter> invertersById;
    private final Map<String, Set<String>> arraysByInverterId;
    private final Map<String, Set<PVModule>> pvModulesByArrayId;
    private final Map<PVModule, Inverter> inverterForPvModules;

    public SolarServiceImpl() {
        pvModules = new LinkedHashSet<>();
        invertersById = new HashMap<>();
        arraysByInverterId = new HashMap<>();
        pvModulesByArrayId = new HashMap<>();
        inverterForPvModules = new HashMap<>();
    }

    @Override
    public void addInverter(Inverter inverter) {
        if (containsInverter(inverter.id)) {
            throw new IllegalArgumentException();
        }

        invertersById.put(inverter.id, inverter);
    }

    @Override
    public void addArray(Inverter inverter, String arrayId) {
        if (!containsInverter(inverter.id)) {
            throw new IllegalArgumentException();
        }

        Set<String> arrays = arraysByInverterId.get(inverter.id);

        if (arrays != null && arrays.contains(arrayId)) {
            throw new IllegalArgumentException();
        }

        if (arrays == null) {
            arrays = new HashSet<>();
        }

        if (arrays.size() >= inverter.maxPvArraysConnected) {
            throw new IllegalArgumentException();
        }

        arrays.add(arrayId);
        arraysByInverterId.put(inverter.id, arrays);
    }

    @Override
    public void addPanel(Inverter inverter, String arrayId, PVModule pvModule) {
        if (!containsInverter(inverter.id)) {
            throw new IllegalArgumentException();
        }

        Set<String> arrays = arraysByInverterId.get(inverter.id);

        if (arrays == null || !arrays.contains(arrayId)) {
            throw new IllegalArgumentException();
        }

        if (pvModules.contains(pvModule)) {
            throw new IllegalArgumentException();
        }

        Set<PVModule> modulesForArrayId = pvModulesByArrayId.get(arrayId);
        if (modulesForArrayId == null) {
            modulesForArrayId = new HashSet<>();
        }

        modulesForArrayId.add(pvModule);
        pvModulesByArrayId.put(arrayId, modulesForArrayId);

        pvModules.add(pvModule);
        inverterForPvModules.put(pvModule, inverter);
    }

    @Override
    public boolean containsInverter(String id) {
        return invertersById.containsKey(id);
    }

    @Override
    public boolean isPanelConnected(PVModule pvModule) {
        return pvModules.contains(pvModule);
    }

    @Override
    public Inverter getInverterByPanel(PVModule pvModule) {
        return inverterForPvModules.get(pvModule);
    }

    @Override
    public void replaceModule(PVModule oldModule, PVModule newModule) {
        Inverter oldInverter = inverterForPvModules.get(oldModule);
        Inverter newInverter = inverterForPvModules.get(newModule);

        if (oldInverter == null || newInverter != null) {
            throw new IllegalArgumentException();
        }

        inverterForPvModules.remove(oldModule);
        inverterForPvModules.put(newModule, oldInverter);

        pvModules.remove(oldModule);
        pvModules.add(newModule);
    }

    @Override
    public Collection<Inverter> getByProductionCapacity() {
        return invertersById.values()
                .stream()
                .sorted((l, r) -> {
                    int lCapacity = getInverterTotalCapacity(l);
                    int rCapacity = getInverterTotalCapacity(r);

                    return lCapacity - rCapacity;
                })
                .collect(Collectors.toList());
    }

    private int getInverterTotalCapacity(Inverter inverter) {
        Set<String> arrays = arraysByInverterId.getOrDefault(inverter.id, new HashSet<>());

        return arrays.stream()
                .map(arrayId -> pvModulesByArrayId.getOrDefault(arrayId, new HashSet<>()))
                .mapToInt(modules -> modules.stream().mapToInt(m -> m.maxWattProduction).sum())
                .sum();
    }

    @Override
    public Collection<Inverter> getByNumberOfPVModulesConnected() {
        return invertersById.values()
                .stream().sorted((l, r) -> {
                    int lModuleCount = getInverterModuleCount(l);
                    int rModuleCount = getInverterModuleCount(r);

                    return lModuleCount - rModuleCount;
                })
                .collect(Collectors.toList());
    }

    private int getInverterModuleCount(Inverter inverter) {
        Set<String> arrays = arraysByInverterId.getOrDefault(inverter.id, new HashSet<>());

        return arrays.stream()
                .map(arrayId -> pvModulesByArrayId.getOrDefault(arrayId, new HashSet<>()))
                .mapToInt(Set::size)
                .sum();
    }

    @Override
    public Collection<PVModule> getByWattProduction() {
        return pvModules.stream()
                .sorted(Comparator.comparingInt(i -> i.maxWattProduction))
                .collect(Collectors.toList());
    }
}
