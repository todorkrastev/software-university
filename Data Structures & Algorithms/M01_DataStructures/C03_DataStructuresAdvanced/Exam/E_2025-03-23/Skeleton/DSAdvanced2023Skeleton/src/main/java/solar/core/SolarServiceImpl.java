package solar.core;

import solar.models.Inverter;
import solar.models.PVModule;

import java.util.*;

public class SolarServiceImpl implements SolarService {
    private final Map<String, Inverter> inverters;
    private final Map<String, Set<String>> inverterArrays;
    private final Map<String, Set<PVModule>> arrayModules;
    private final Map<PVModule, String> moduleInverterMap;
    private final Map<PVModule, String> moduleArrayMap;

    private List<Inverter> cachedInvertersByProductionCapacity;
    private List<Inverter> cachedInvertersByNumberOfPVModulesConnected;
    private List<PVModule> cachedPVModulesByWattProduction;
    private boolean isCacheValid;

    public SolarServiceImpl() {
        this.inverters = new HashMap<>();
        this.inverterArrays = new HashMap<>();
        this.arrayModules = new HashMap<>();
        this.moduleInverterMap = new HashMap<>();
        this.moduleArrayMap = new HashMap<>();
        this.isCacheValid = false;
    }

    @Override
    public void addInverter(Inverter inverter) {
        if (inverters.containsKey(inverter.id)) {
            throw new IllegalArgumentException("Inverter already exists");
        }

        inverters.put(inverter.id, inverter);
        inverterArrays.put(inverter.id, new HashSet<>());
        invalidateCache();
    }

    @Override
    public void addArray(Inverter inverter, String arrayId) {
        if (!inverters.containsKey(inverter.id) || arrayModules.containsKey(arrayId) || inverterArrays.get(inverter.id).size() >= inverter.maxPvArraysConnected) {
            throw new IllegalArgumentException("Invalid inverter or arrayId");
        }

        inverterArrays.get(inverter.id).add(arrayId);
        arrayModules.put(arrayId, new HashSet<>());
        invalidateCache();
    }

    @Override
    public void addPanel(Inverter inverter, String arrayId, PVModule pvModule) {
        if (!inverters.containsKey(inverter.id) || !inverterArrays.get(inverter.id).contains(arrayId) || moduleInverterMap.containsKey(pvModule)) {
            throw new IllegalArgumentException("Invalid inverter, arrayId or PVModule");
        }

        arrayModules.get(arrayId).add(pvModule);
        moduleInverterMap.put(pvModule, inverter.id);
        moduleArrayMap.put(pvModule, arrayId);
        invalidateCache();
    }

    @Override
    public boolean containsInverter(String id) {
        return inverters.containsKey(id);
    }

    @Override
    public boolean isPanelConnected(PVModule pvModule) {
        return moduleInverterMap.containsKey(pvModule);
    }

    @Override
    public Inverter getInverterByPanel(PVModule pvModule) {
        String inverterId = moduleInverterMap.get(pvModule);
        return inverterId != null ? inverters.get(inverterId) : null;
    }

    @Override
    public void replaceModule(PVModule oldModule, PVModule newModule) {
        if (!moduleInverterMap.containsKey(oldModule) || moduleInverterMap.containsKey(newModule)) {
            throw new IllegalArgumentException("Invalid oldModule or newModule");
        }

        String inverterId = moduleInverterMap.get(oldModule);
        String arrayId = moduleArrayMap.get(oldModule);

        moduleInverterMap.remove(oldModule);
        moduleInverterMap.put(newModule, inverterId);

        moduleArrayMap.remove(oldModule);
        moduleArrayMap.put(newModule, arrayId);

        Set<PVModule> modules = arrayModules.get(arrayId);
        modules.remove(oldModule);
        modules.add(newModule);
        invalidateCache();
    }

    @Override
    public Collection<Inverter> getByProductionCapacity() {
        if (!isCacheValid || cachedInvertersByProductionCapacity == null) {
            cachedInvertersByProductionCapacity = new ArrayList<>(inverters.values());
            cachedInvertersByProductionCapacity.sort(Comparator.comparingInt(this::calculateTotalProductionCapacity));
        }
        return cachedInvertersByProductionCapacity;
    }

    @Override
    public Collection<Inverter> getByNumberOfPVModulesConnected() {
        if (!isCacheValid || cachedInvertersByNumberOfPVModulesConnected == null) {
            cachedInvertersByNumberOfPVModulesConnected = new ArrayList<>(inverters.values());
            cachedInvertersByNumberOfPVModulesConnected.sort(Comparator.comparingInt((Inverter inv) -> getTotalModulesConnected(inv.id))
                    .thenComparingInt(inv -> inverterArrays.get(inv.id).size()));
        }
        return cachedInvertersByNumberOfPVModulesConnected;
    }

    @Override
    public Collection<PVModule> getByWattProduction() {
        if (!isCacheValid || cachedPVModulesByWattProduction == null) {
            cachedPVModulesByWattProduction = new ArrayList<>(moduleInverterMap.keySet());
            cachedPVModulesByWattProduction.sort(Comparator.comparingInt((PVModule pvModule) -> pvModule.maxWattProduction)
                    .thenComparingInt(pvModule -> new ArrayList<>(moduleInverterMap.keySet()).indexOf(pvModule)));
        }
        return cachedPVModulesByWattProduction;
    }

    private int calculateTotalProductionCapacity(Inverter inverter) {
        return inverterArrays.get(inverter.id).stream()
                .flatMap(arrayId -> arrayModules.get(arrayId).stream())
                .mapToInt(pvModule -> pvModule.maxWattProduction)
                .sum();
    }

    private int getTotalModulesConnected(String inverterId) {
        return inverterArrays.get(inverterId).stream()
                .mapToInt(arrayId -> arrayModules.get(arrayId).size())
                .sum();
    }

    private void invalidateCache() {
        isCacheValid = false;
        cachedInvertersByProductionCapacity = null;
        cachedInvertersByNumberOfPVModulesConnected = null;
        cachedPVModulesByWattProduction = null;
    }
}