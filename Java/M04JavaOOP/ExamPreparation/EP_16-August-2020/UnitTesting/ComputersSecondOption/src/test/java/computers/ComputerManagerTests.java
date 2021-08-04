package computers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer MacbookPro;
    private Computer MacbookAir;


    @Before
    public void setUp() {
        this.computerManager = new ComputerManager();
        this.MacbookPro = new Computer("MacBook", "Pro", 1700.00);
        this.MacbookAir = new Computer("MacBook", "Air", 1200.00);
    }

    @Test
    public void testGetCount() {
        computerManager.addComputer(MacbookPro);
        int actual = computerManager.getCount();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputers() {
        computerManager.getComputers().remove(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTwoTimes() {
        computerManager.addComputer(MacbookPro);
        computerManager.addComputer(MacbookPro);
    }

    @Test
    public void testRemoveComputer() {
        computerManager.addComputer(MacbookPro);
        computerManager.removeComputer(MacbookPro.getManufacturer(), MacbookPro.getModel());
        int actual = computerManager.getComputers().size();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNullComputer() {
        computerManager.getComputer("HP", "LAPTOP");
    }

    @Test
    public void testGetComputersByManufacturer() {
        computerManager.addComputer(MacbookPro);
        int actual = computerManager.getComputersByManufacturer(MacbookPro.getManufacturer()).size();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetPrice() {
        double actual = MacbookAir.getPrice();
        double expected = 1200.00;
        assertEquals(expected, actual, 0.00);
    }
}