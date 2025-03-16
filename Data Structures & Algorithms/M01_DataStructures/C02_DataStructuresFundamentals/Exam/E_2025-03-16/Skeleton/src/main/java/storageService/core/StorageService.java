package storageService.core;

import storageService.models.Box;
import storageService.models.StorageUnit;

import java.util.Collection;

public interface StorageService {
    void  rentStorage(StorageUnit unit);
    void storeBox(Box box);
    boolean isStored(Box box);
    boolean isRented(StorageUnit unit);
    boolean contains(StorageUnit unit, String boxId);
    Box retrieve(StorageUnit unit, String boxId);
    int getTotalFreeSpace();
    StorageUnit getMostAvailableSpaceUnit();
    Collection<Box> getAllBoxesByVolume();
    Collection<StorageUnit> getAllUnitsByFillRate();
}
