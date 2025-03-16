package storageService.models;

import java.util.HashMap;
import java.util.Map;

public class StorageUnit {
    public String id;

    public int totalAvailableSpace;

    public int totalUsedSpace;

    private Map<String, Box> boxes;

    public StorageUnit(String id, int totalAvailableSpace, int totalUsedSpace) {
        this.id = id;
        this.totalAvailableSpace = totalAvailableSpace;
        this.totalUsedSpace = totalUsedSpace;
        this.boxes = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public int getTotalAvailableSpace() {
        return totalAvailableSpace;
    }

    public int getTotalUsedSpace() {
        return totalUsedSpace;
    }

    public int getFreeSpace() {
        return totalAvailableSpace - totalUsedSpace;
    }

    public void storeBox(Box box) {
        if (getFreeSpace() < box.getVolume()) {
            throw new IllegalArgumentException("Not enough space to store the box.");
        }
        boxes.put(box.getId(), box);
        totalUsedSpace += box.getVolume();
    }

    public boolean containsBox(String boxId) {
        return boxes.containsKey(boxId);
    }

    public Box retrieveBox(String boxId) {
        Box box = boxes.remove(boxId);
        if (box != null) {
            totalUsedSpace -= box.getVolume();
        }
        return box;
    }

    public int getTotalSpace() {
        return totalAvailableSpace;
    }
}
