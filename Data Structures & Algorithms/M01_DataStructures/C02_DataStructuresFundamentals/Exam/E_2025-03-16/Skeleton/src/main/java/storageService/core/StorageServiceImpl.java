package storageService.core;

import storageService.models.Box;
import storageService.models.StorageUnit;

import java.util.*;

public class StorageServiceImpl implements StorageService {
    private final Map<String, StorageUnit> storageUnits = new TreeMap<>();
    private final Map<String, Box> storedBoxes = new TreeMap<>();
    private final PriorityQueue<StorageUnit> availableSpaceQueue = new PriorityQueue<>(Comparator.comparingInt(StorageUnit::getFreeSpace).reversed());

    @Override
    public void rentStorage(StorageUnit unit) {
        if (storageUnits.containsKey(unit.getId())) {
            throw new IllegalArgumentException("Storage unit with the same ID already exists.");
        }
        storageUnits.put(unit.getId(), unit);
        availableSpaceQueue.add(unit);
    }

    @Override
    public void storeBox(Box box) {
        if (storedBoxes.containsKey(box.getId())) {
            throw new IllegalArgumentException("Box is already stored.");
        }
        if (availableSpaceQueue.isEmpty()) {
            throw new IllegalArgumentException("No storage units available.");
        }

        StorageUnit bestUnit = availableSpaceQueue.peek();
        if (bestUnit.getFreeSpace() < box.getVolume()) {
            throw new IllegalArgumentException("No storage unit has enough room for the box.");
        }

        bestUnit.storeBox(box);
        storedBoxes.put(box.getId(), box);
        availableSpaceQueue.remove(bestUnit);
        availableSpaceQueue.add(bestUnit);
    }

    @Override
    public boolean isStored(Box box) {
        return storedBoxes.containsKey(box.getId());
    }

    @Override
    public boolean isRented(StorageUnit unit) {
        return storageUnits.containsKey(unit.getId());
    }

    @Override
    public boolean contains(StorageUnit unit, String boxId) {
        if (!storageUnits.containsKey(unit.getId())) {
            return false;
        }
        return unit.containsBox(boxId);
    }

    @Override
    public Box retrieve(StorageUnit unit, String boxId) {
        if (!storageUnits.containsKey(unit.getId())) {
            throw new IllegalArgumentException("Storage unit not found.");
        }
        Box box = unit.retrieveBox(boxId);
        if (box == null) {
            throw new IllegalArgumentException("Box not found in the storage unit.");
        }
        storedBoxes.remove(boxId);
        availableSpaceQueue.remove(unit);
        availableSpaceQueue.add(unit);
        return box;
    }

    @Override
    public int getTotalFreeSpace() {
        return storageUnits.values().stream().mapToInt(StorageUnit::getFreeSpace).sum();
    }

    @Override
    public StorageUnit getMostAvailableSpaceUnit() {
        if (availableSpaceQueue.isEmpty()) {
            throw new IllegalArgumentException("No storage units available.");
        }
        return availableSpaceQueue.peek();
    }

    @Override
    public Collection<Box> getAllBoxesByVolume() {
        List<Box> boxes = new ArrayList<>(storedBoxes.values());
        boxes.sort(Comparator.comparingInt(Box::getVolume)
                .thenComparing(Comparator.comparingInt(Box::getHeight).reversed()));
        return boxes;
    }

    @Override
    public Collection<StorageUnit> getAllUnitsByFillRate() {
        List<StorageUnit> units = new ArrayList<>(storageUnits.values());
        units.sort(Comparator.comparingInt((StorageUnit unit) -> (unit.getFreeSpace() * 100) / unit.getTotalSpace())
                .reversed()
                .thenComparingInt(StorageUnit::getTotalSpace)
                .reversed());
        return units;
    }
}