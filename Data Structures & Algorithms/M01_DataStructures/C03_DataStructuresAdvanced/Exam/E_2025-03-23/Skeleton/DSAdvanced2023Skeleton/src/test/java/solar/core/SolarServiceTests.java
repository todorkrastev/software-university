package solar.core;

import org.junit.Before;
import org.junit.Test;
import solar.models.Inverter;
import solar.models.PVModule;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class SolarServiceTests {
    private SolarService service;

    private final Inverter inverter = new Inverter("initial", 5);

    private final PVModule pvModule = new PVModule(10);

    @Before
    public void setup() {
        service = new SolarServiceImpl();
    }

    @Test
    public void addInverter() {
        service.addInverter(inverter);

        assertTrue(service.containsInverter(inverter.id));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addSameInverterTwice() {
        service.addInverter(inverter);
        service.addInverter(inverter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addArrayForMissingInverter() {
        service.addArray(inverter, "first");
    }

    @Test
    public void addPanel() {
        service.addInverter(inverter);
        service.addArray(inverter, "first");

        service.addPanel(inverter, "first", pvModule);

        assertTrue(service.isPanelConnected(pvModule));
    }

    @Test
    public void replaceModule() {
        service.addInverter(inverter);
        service.addArray(inverter, "first");
        service.addPanel(inverter, "first", pvModule);

        PVModule secondModule = new PVModule(5);

        service.replaceModule(pvModule, secondModule);

        assertNull(service.getInverterByPanel(pvModule));
        assertEquals(inverter, service.getInverterByPanel(secondModule));

        assertFalse(service.isPanelConnected(pvModule));
        assertTrue(service.isPanelConnected(secondModule));
    }

    @Test
    public void getByProductionCapacity() {
        Inverter inverter1 = new Inverter("inverter1", 5);
        Inverter inverter2 = new Inverter("inverter2", 5);
        Inverter inverter3 = new Inverter("inverter3", 5);

        PVModule pvModule1 = new PVModule(10);
        PVModule pvModule2 = new PVModule(20);
        PVModule pvModule3 = new PVModule(30);

        service.addInverter(inverter1);
        service.addInverter(inverter2);
        service.addInverter(inverter3);

        service.addArray(inverter1, "array1");
        service.addArray(inverter2, "array2");
        service.addArray(inverter3, "array3");

        service.addPanel(inverter1, "array1", pvModule1);
        service.addPanel(inverter2, "array2", pvModule2);
        service.addPanel(inverter3, "array3", pvModule3);

        Collection<Inverter> sortedInverters = service.getByProductionCapacity();
        Iterator<Inverter> iterator = sortedInverters.iterator();

        assertEquals(inverter1, iterator.next());
        assertEquals(inverter2, iterator.next());
        assertEquals(inverter3, iterator.next());
    }

    @Test
    public void getByNumberOfPVModulesConnected() {
        Inverter inverter1 = new Inverter("inverter1", 5);
        Inverter inverter2 = new Inverter("inverter2", 5);
        Inverter inverter3 = new Inverter("inverter3", 5);

        PVModule pvModule1 = new PVModule(10);
        PVModule pvModule2 = new PVModule(20);
        PVModule pvModule3 = new PVModule(30);
        PVModule pvModule4 = new PVModule(40);

        service.addInverter(inverter1);
        service.addInverter(inverter2);
        service.addInverter(inverter3);

        service.addArray(inverter1, "array1");
        service.addArray(inverter2, "array2");
        service.addArray(inverter2, "array3");
        service.addArray(inverter3, "array4");

        service.addPanel(inverter1, "array1", pvModule1);
        service.addPanel(inverter2, "array2", pvModule2);
        service.addPanel(inverter2, "array3", pvModule3);
        service.addPanel(inverter3, "array4", pvModule4);

        Collection<Inverter> sortedInverters = service.getByNumberOfPVModulesConnected();
        Iterator<Inverter> iterator = sortedInverters.iterator();

        assertEquals(inverter1, iterator.next());
        assertEquals(inverter3, iterator.next());
        assertEquals(inverter2, iterator.next());
    }

    @Test
    public void getByWattProduction() {
        Inverter inverter1 = new Inverter("inverter1", 5);
        Inverter inverter2 = new Inverter("inverter2", 5);

        PVModule pvModule1 = new PVModule(10);
        PVModule pvModule2 = new PVModule(20);
        PVModule pvModule3 = new PVModule(15);

        service.addInverter(inverter1);
        service.addInverter(inverter2);

        service.addArray(inverter1, "array1");
        service.addArray(inverter2, "array2");

        service.addPanel(inverter1, "array1", pvModule1);
        service.addPanel(inverter1, "array1", pvModule3);
        service.addPanel(inverter2, "array2", pvModule2);

        Collection<PVModule> sortedModules = service.getByWattProduction();
        Iterator<PVModule> iterator = sortedModules.iterator();

        assertEquals(pvModule1, iterator.next());
        assertEquals(pvModule3, iterator.next());
        assertEquals(pvModule2, iterator.next());
    }
}
