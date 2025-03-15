package renovation.core;

import org.junit.Before;
import org.junit.Test;
import renovation.models.Tile;

import static org.junit.Assert.assertTrue;

public class RenovationPerformanceTests {

    private ConcreteRenovation renovationService;

    @Before
    public void setUp() {
        int arg1 = 1;
        int arg2 = 2;
        int arg3 = 3;

        renovationService = new ConcreteRenovation(arg1, arg2, arg3);
    }

    @Test
    public void testRenovationPerformance() {
        long startTime = System.currentTimeMillis();

        Tile tile = new Tile();
        renovationService.renovate(tile);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        assertTrue("Renovation took too long", duration < 1000);
    }

    @Test
    public void testMultipleRenovationsPerformance() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            Tile tile = new Tile();
            renovationService.renovate(tile);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        assertTrue("Multiple renovations took too long", duration < 5000);
    }
}