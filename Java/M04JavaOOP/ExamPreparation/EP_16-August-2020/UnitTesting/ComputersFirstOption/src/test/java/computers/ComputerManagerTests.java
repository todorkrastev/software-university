package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer computer;
    private Computer computer2;


    @Before
    public void setUp() {
        this.computerManager = new ComputerManager();
        computer = new Computer("DELL", "A4532", 300.00);
        computer2 = new Computer("ASUS", "ROG", 600.00);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputers() {
        computerManager.getComputers().remove(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullAdd() {
        this.computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSecondAdd() {
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(computer);
    }

    @Test
    public void testAdd() {
        this.computerManager.addComputer(computer);
        Assert.assertEquals(1, this.computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldReturnNullForManufacturer() {
        this.computerManager.getComputer(null, "test_model");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldReturnNullForModel() {
        this.computerManager.getComputer("test_manufacturer", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNotExisting() {
        this.computerManager.getComputer(computer.getManufacturer(), computer.getModel());
    }

    @Test
    public void testGetReturnsProperlyInformation() {
        computerManager.addComputer(computer);
        computerManager.addComputer(computer2);
        Computer returned = this.computerManager.getComputer(this.computer.getManufacturer(), this.computer.getModel());

        Assert.assertEquals(computer.getManufacturer(), returned.getManufacturer());
        Assert.assertEquals(computer.getModel(), returned.getModel());
    }

    @Test
    public void testGetByManufacturer() {
        computerManager.addComputer(computer);
        computerManager.addComputer(computer2);

        List<Computer> list = computerManager.getComputersByManufacturer(computer.getManufacturer());
        Assert.assertNotNull(list);
        Assert.assertEquals(list.get(0).getManufacturer(), computer.getManufacturer());
    }

    @Test
    public void testGetByManufacturerWhenIsEmpty() {
        List<Computer> list = computerManager.getComputersByManufacturer(computer.getManufacturer());
        Assert.assertNotNull(list);
        Assert.assertTrue(list.isEmpty());
    }

}