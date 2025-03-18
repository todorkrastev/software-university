package storageService.core;

import storageService.models.Box;
import storageService.models.StorageUnit;

import java.util.*;
import java.util.stream.Collectors;

public class StorageServiceImpl implements StorageService {
    private final PriorityQueue<StorageUnit> unitsBySpace = new PriorityQueue<>((l, r) -> (r.totalAvailableSpace - r.totalUsedSpace) - (l.totalAvailableSpace - l.totalUsedSpace));

    private final Map<String, Box> boxes = new HashMap<>();
    private final Map<String, StorageUnit> units = new HashMap<>();
    private final Map<String, StorageUnit> boxIdToUnit = new HashMap<>();

    int totalUsableSpace = 0;

    @Override
    public void rentStorage(StorageUnit unit) {
        if (units.containsKey(unit.id)) {
            throw new IllegalArgumentException();
        }

        units.put(unit.id, unit);
        unitsBySpace.offer(unit);

        totalUsableSpace += unit.totalAvailableSpace;
    }

    @Override
    public void storeBox(Box box) {
        if (boxes.containsKey(box.id)) {
            throw new IllegalArgumentException();
        }

        if (unitsBySpace.isEmpty()) {
            throw new IllegalArgumentException();
        }

        StorageUnit unit = unitsBySpace.poll();
        int volume = box.width * box.height * box.depth;

        if (unit.totalAvailableSpace - unit.totalUsedSpace < volume) {
            throw new IllegalArgumentException();
        }

        unit.totalUsedSpace += volume;
        totalUsableSpace -= volume;

        unitsBySpace.offer(unit);
        boxes.put(box.id, box);
        boxIdToUnit.put(box.id, unit);
    }

    @Override
    public boolean isStored(Box box) {
        return boxes.containsKey(box.id);
    }

    @Override
    public boolean isRented(StorageUnit unit) {
        return units.containsKey(unit.id);
    }

    @Override
    public boolean contains(StorageUnit unit, String boxId) {
        StorageUnit actualUnit = boxIdToUnit.get(boxId);

        if (actualUnit == null) {
            return false;
        }

        return actualUnit.id.equals(unit.id);
    }

    @Override
    public Box retrieve(StorageUnit unit, String boxId) {
        if (!contains(unit, boxId)) {
            throw new IllegalArgumentException();
        }

        Box box = boxes.get(boxId);
        int volume = box.width * box.height * box.depth;

        unit.totalUsedSpace -= volume;
        totalUsableSpace += volume;

        return boxes.remove(boxId);
    }

    @Override
    public int getTotalFreeSpace() {
        return totalUsableSpace;
    }

    @Override
    public StorageUnit getMostAvailableSpaceUnit() {
        if (unitsBySpace.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return unitsBySpace.peek();
    }

    @Override
    public Collection<Box> getAllBoxesByVolume() {
        return boxes.values()
                .stream()
                .sorted((l, r) -> {
                    int lVolume = l.width * l.height * l.depth;
                    int rVolume = r.width * r.height * r.depth;

                    if (lVolume == rVolume) {
                        return r.height - l.height;
                    }

                    return lVolume - rVolume;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Collection<StorageUnit> getAllUnitsByFillRate() {
        return units.values()
                .stream()
                .sorted((l, r) -> {
                    int lFillRate = (l.totalAvailableSpace - l.totalUsedSpace) / l.totalAvailableSpace;
                    int rFillRate = (r.totalAvailableSpace - r.totalUsedSpace) / r.totalAvailableSpace;

                    if (lFillRate == rFillRate) {
                        return r.totalAvailableSpace - l.totalAvailableSpace;
                    }

                    return rFillRate - lFillRate;
                })
                .collect(Collectors.toList());
    }
}
