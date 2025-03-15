package craftsmanLab.core;

import craftsmanLab.models.ApartmentRenovation;
import craftsmanLab.models.Craftsman;

import java.util.*;
import java.util.stream.Collectors;

public class CraftsmanLabImpl implements CraftsmanLab {
    private final Map<String, ApartmentRenovation> apartments = new TreeMap<>();
    private final Map<String, Craftsman> craftsmen = new TreeMap<>();
    private final Map<ApartmentRenovation, Craftsman> assignments = new HashMap<>();
    private final PriorityQueue<Craftsman> leastProfitableCraftsmen = new PriorityQueue<>(Comparator.comparingDouble(Craftsman::getTotalEarnings));

    @Override
    public void addApartment(ApartmentRenovation job) {
        if (apartments.containsKey(job.getAddress())) {
            throw new IllegalArgumentException("Apartment with this address already exists.");
        }
        apartments.put(job.getAddress(), job);
    }

    @Override
    public void addCraftsman(Craftsman craftsman) {
        if (craftsmen.containsKey(craftsman.getName())) {
            throw new IllegalArgumentException("Craftsman already exists.");
        }
        craftsmen.put(craftsman.getName(), craftsman);
        leastProfitableCraftsmen.add(craftsman);
    }

    @Override
    public boolean exists(ApartmentRenovation job) {
        return apartments.containsKey(job.getAddress());
    }

    @Override
    public boolean exists(Craftsman craftsman) {
        return craftsmen.containsKey(craftsman.getName());
    }

    @Override
    public void removeCraftsman(Craftsman craftsman) {
        if (!craftsmen.containsKey(craftsman.getName()) || assignments.containsValue(craftsman)) {
            throw new IllegalArgumentException("Craftsman is missing or already assigned to a renovation.");
        }
        craftsmen.remove(craftsman.getName());
        leastProfitableCraftsmen.remove(craftsman);
    }

    @Override
    public Collection<Craftsman> getAllCraftsmen() {
        return new ArrayList<>(craftsmen.values());
    }

    @Override
    public void assignRenovations() {
        for (ApartmentRenovation job : apartments.values()) {
            if (!assignments.containsKey(job)) {
                Craftsman leastProfitable = leastProfitableCraftsmen.poll();
                if (leastProfitable == null) {
                    throw new IllegalArgumentException("No craftsmen available.");
                }
                assignments.put(job, leastProfitable);
                leastProfitable.addEarnings(job.getWorkHoursNeeded() * leastProfitable.getHourlyRate());
                leastProfitableCraftsmen.add(leastProfitable);
            }
        }
    }

    @Override
    public Craftsman getContractor(ApartmentRenovation job) {
        Craftsman craftsman = assignments.get(job);
        if (craftsman == null) {
            throw new IllegalArgumentException("No craftsman assigned to this apartment.");
        }
        return craftsman;
    }

    @Override
    public Craftsman getLeastProfitable() {
        Craftsman leastProfitable = leastProfitableCraftsmen.peek();
        if (leastProfitable == null) {
            throw new IllegalArgumentException("No craftsmen available.");
        }
        return leastProfitable;
    }

    @Override
    public Collection<ApartmentRenovation> getApartmentsByRenovationCost() {
        List<ApartmentRenovation> sortedApartments = new ArrayList<>(apartments.values());
        sortedApartments.sort((a1, a2) -> {
            double cost1 = a1.getWorkHoursNeeded() * (assignments.containsKey(a1) ? assignments.get(a1).getHourlyRate() : 1);
            double cost2 = a2.getWorkHoursNeeded() * (assignments.containsKey(a2) ? assignments.get(a2).getHourlyRate() : 1);
            return Double.compare(cost2, cost1);
        });
        return sortedApartments;
    }

    @Override
    public Collection<ApartmentRenovation> getMostUrgentRenovations(int count) {
        return apartments.values().stream()
                .sorted(Comparator.comparing(ApartmentRenovation::getDeadline))
                .limit(count)
                .collect(Collectors.toList());
    }
}