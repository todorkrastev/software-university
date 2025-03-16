package storageService.core;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import storageService.models.Box;
import storageService.models.StorageUnit;

import java.util.Collection;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class StorageServiceTests {
    private StorageService storageService;

    private final StorageUnit unit = new StorageUnit("first", 100, 0);
    private final Box box = new Box("some", 10, 2, 2);

    @Before
    public void setup() {
        storageService = new StorageServiceImpl();
    }

    @Test
    public void rentStorage() {
        storageService.rentStorage(unit);

        assertEquals(100, storageService.getTotalFreeSpace());
    }

    @Test
    public void storeBox() {
        storageService.rentStorage(unit);

        storageService.storeBox(box);

        TestCase.assertEquals(60, storageService.getTotalFreeSpace());
    }

    @Test(expected = IllegalArgumentException.class)
    public void storeSameBox() {
        storageService.rentStorage(unit);

        storageService.storeBox(box);
        storageService.storeBox(box);
    }

    @Test
    public void isRented() {
        storageService.rentStorage(unit);

        assertTrue(storageService.isRented(unit));
    }

    @Test
    public void containsWithNonExistingUnit() {
        assertFalse(storageService.contains(unit, box.id));
    }

    @Test
    public void retrievesWithStoredBox() {
        storageService.rentStorage(unit);
        storageService.storeBox(box);

        assertEquals(storageService.retrieve(unit, box.id), box);
        assertEquals(100, storageService.getTotalFreeSpace());
    }

    @Test
    public void getAllBoxesOnEmptyService() {
        Collection<Box> allBoxesByVolume = storageService.getAllBoxesByVolume();

        assertTrue(allBoxesByVolume.isEmpty());
    }
}
