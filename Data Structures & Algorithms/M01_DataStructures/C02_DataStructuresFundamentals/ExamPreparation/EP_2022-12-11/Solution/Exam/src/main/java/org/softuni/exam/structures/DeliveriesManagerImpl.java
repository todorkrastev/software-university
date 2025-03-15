package org.softuni.exam.structures;

import org.softuni.exam.entities.Deliverer;
import org.softuni.exam.entities.Package;

import java.util.*;

public class DeliveriesManagerImpl implements DeliveriesManager {
    private Map<String, Deliverer> deliverers;
    private Map<String, Package> packages;
    private Map<Deliverer, List<Package>> delivererPackages;
    private Set<Package> unassignedPackages;

    public DeliveriesManagerImpl() {
        this.deliverers = new LinkedHashMap<>();
        this.packages = new LinkedHashMap<>();
        this.delivererPackages = new LinkedHashMap<>();
        this.unassignedPackages = new LinkedHashSet<>();
    }

    @Override
    public void addDeliverer(Deliverer deliverer) {
        this.deliverers.put(deliverer.getId(), deliverer);
        this.delivererPackages.putIfAbsent(deliverer, new ArrayList<>());
    }

    @Override
    public void addPackage(Package _package) {
        this.packages.put(_package.getId(), _package);
        this.unassignedPackages.add(_package);
    }

    @Override
    public boolean contains(Deliverer deliverer) {
        return this.deliverers.containsKey(deliverer.getId());
    }

    @Override
    public boolean contains(Package _package) {
        return this.packages.containsKey(_package.getId());
    }

    @Override
    public Iterable<Deliverer> getDeliverers() {
        return this.deliverers.values();
    }

    @Override
    public Iterable<Package> getPackages() {
        return this.packages.values();
    }

    @Override
    public void assignPackage(Deliverer deliverer, Package _package) throws IllegalArgumentException {
        if (!this.contains(deliverer) || !this.contains(_package)) {
            throw new IllegalArgumentException();
        }
        this.delivererPackages.get(deliverer).add(_package);
        this.unassignedPackages.remove(_package);
    }

    @Override
    public Iterable<Package> getUnassignedPackages() {
        return this.unassignedPackages;
    }

    @Override
    public Iterable<Package> getPackagesOrderedByWeightThenByReceiver() {
        List<Package> sortedPackages = new ArrayList<>(this.packages.values());
        sortedPackages.sort(Comparator.comparing(Package::getWeight).reversed()
                .thenComparing(Package::getReceiver));
        return sortedPackages;
    }

    @Override
    public Iterable<Deliverer> getDeliverersOrderedByCountOfPackagesThenByName() {
        List<Deliverer> sortedDeliverers = new ArrayList<>(this.deliverers.values());
        sortedDeliverers.sort(Comparator.comparing((Deliverer d) -> this.delivererPackages.get(d).size()).reversed()
                .thenComparing(Deliverer::getName));
        return sortedDeliverers;
    }
}