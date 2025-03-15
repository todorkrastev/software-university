package craftsmanLab.core;

import craftsmanLab.models.ApartmentRenovation;
import craftsmanLab.models.Craftsman;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.Assert.*;

public class CraftsmanLabImplTest {

    private CraftsmanLabImpl craftsmanLab;
    private ApartmentRenovation apartment1;
    private ApartmentRenovation apartment2;
    private Craftsman craftsman1;
    private Craftsman craftsman2;

    @Before
    public void setUp() {
        craftsmanLab = new CraftsmanLabImpl();
        apartment1 = new ApartmentRenovation("123 Main St", 10.0, 100.0, LocalDate.now());
        apartment2 = new ApartmentRenovation("456 Elm St", 5.0, 50.0, LocalDate.now().plusDays(1));
        craftsman1 = new Craftsman("John Doe", 20.0, 15.0);
        craftsman2 = new Craftsman("Jane Smith", 25.0, 20.0);
    }

    @Test
    public void testAddApartment() {
        craftsmanLab.addApartment(apartment1);
        assertTrue(craftsmanLab.exists(apartment1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddApartmentDuplicate() {
        craftsmanLab.addApartment(apartment1);
        craftsmanLab.addApartment(apartment1);
    }

    @Test
    public void testAddCraftsman() {
        craftsmanLab.addCraftsman(craftsman1);
        assertTrue(craftsmanLab.exists(craftsman1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCraftsmanDuplicate() {
        craftsmanLab.addCraftsman(craftsman1);
        craftsmanLab.addCraftsman(craftsman1);
    }

    @Test
    public void testRemoveCraftsman() {
        craftsmanLab.addCraftsman(craftsman1);
        craftsmanLab.removeCraftsman(craftsman1);
        assertFalse(craftsmanLab.exists(craftsman1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCraftsmanAssigned() {
        craftsmanLab.addCraftsman(craftsman1);
        craftsmanLab.addApartment(apartment1);
        craftsmanLab.assignRenovations();
        craftsmanLab.removeCraftsman(craftsman1);
    }

    @Test
    public void testGetAllCraftsmen() {
        craftsmanLab.addCraftsman(craftsman1);
        craftsmanLab.addCraftsman(craftsman2);
        Collection<Craftsman> craftsmen = craftsmanLab.getAllCraftsmen();
        assertEquals(2, craftsmen.size());
        assertTrue(craftsmen.contains(craftsman1));
        assertTrue(craftsmen.contains(craftsman2));
    }

    @Test
    public void testAssignRenovations() {
        craftsmanLab.addCraftsman(craftsman1);
        craftsmanLab.addApartment(apartment1);
        craftsmanLab.assignRenovations();
        assertEquals(craftsman1, craftsmanLab.getContractor(apartment1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAssignRenovationsNoCraftsmen() {
        craftsmanLab.addApartment(apartment1);
        craftsmanLab.assignRenovations();
    }

    @Test
    public void testGetContractor() {
        craftsmanLab.addCraftsman(craftsman1);
        craftsmanLab.addApartment(apartment1);
        craftsmanLab.assignRenovations();
        assertEquals(craftsman1, craftsmanLab.getContractor(apartment1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetContractorNotAssigned() {
        craftsmanLab.addApartment(apartment1);
        craftsmanLab.getContractor(apartment1);
    }

    @Test
    public void testGetLeastProfitable() {
        craftsmanLab.addCraftsman(craftsman1);
        craftsmanLab.addCraftsman(craftsman2);
        assertEquals(craftsman1, craftsmanLab.getLeastProfitable());
    }

    @Test
    public void testGetApartmentsByRenovationCost() {
        craftsmanLab.addApartment(apartment1);
        craftsmanLab.addApartment(apartment2);
        craftsmanLab.addCraftsman(craftsman1);
        craftsmanLab.assignRenovations();
        Collection<ApartmentRenovation> apartments = craftsmanLab.getApartmentsByRenovationCost();
        assertEquals(2, apartments.size());
        assertEquals(apartment1, apartments.iterator().next());
    }

    @Test
    public void testGetMostUrgentRenovations() {
        craftsmanLab.addApartment(apartment1);
        craftsmanLab.addApartment(apartment2);
        Collection<ApartmentRenovation> urgentApartments = craftsmanLab.getMostUrgentRenovations(1);
        assertEquals(1, urgentApartments.size());
        assertEquals(apartment1, urgentApartments.iterator().next());
    }
}