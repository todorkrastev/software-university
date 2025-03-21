import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class MicrosystemsTest {
    private Microsystems microsystems;

    @Before
    public void setUp() {
        this.microsystems = new MicrosystemsImpl();
    }

    @Test
    public void count_should_work_correctly() {

        Computer computer1 = new Computer(2, Brand.ACER, 1120, 15.6, "grey");
        Computer computer = new Computer(1, Brand.DELL, 2300, 15.6, "grey");
        Computer computer2 = new Computer(5, Brand.HP, 2400, 13.6, "red");


        this.microsystems.createComputer(computer);
        this.microsystems.createComputer(computer1);
        this.microsystems.createComputer(computer2);

        final int expectedCount = 3;
        final int actualCount = this.microsystems.count();

        assertEquals("Incorrect count", expectedCount, actualCount);
    }

    @Test
    public void createComputer_should_return_true_with_valid_number() {

        Computer computer1 = new Computer(2, Brand.ACER, 1120, 15.6, "grey");
        Computer computer = new Computer(1, Brand.DELL, 2300, 15.6, "grey");


        this.microsystems.createComputer(computer);
        this.microsystems.createComputer(computer1);

        assertTrue("Incorrect return value", this.microsystems.contains(1));
        assertTrue("Incorrect return value", this.microsystems.contains(2));
    }

    @Test
    public void createComputer_should_increase_count() {
        Computer computer1 = new Computer(1, Brand.ACER, 1120, 15.6, "grey");
        Computer computer2 = new Computer(2, Brand.ASUS, 2000, 15.6, "red");

        this.microsystems.createComputer(computer1);
        this.microsystems.createComputer(computer2);
        final int expectedCount = 2;
        final int actualCount = this.microsystems.count();

        assertEquals("Incorrect count", expectedCount, actualCount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createComputer_should_throw_exception() {

        Computer computer = new Computer(1, Brand.ASUS, 10D, 13.3, "red");
        Computer computer1 = new Computer(1, Brand.DELL, 11D, 14.3, "black");

        this.microsystems.createComputer(computer);
        this.microsystems.createComputer(computer1);
    }

    @Test
    public void remove_should_work_correctly() {
        Computer computer = new Computer(1, Brand.DELL, 2300, 15.6, "grey");
        this.microsystems.createComputer(computer);
        this.microsystems.remove(1);
        assertFalse("Computer should be removed", this.microsystems.contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void remove_should_throw_exception_if_not_exists() {
        this.microsystems.remove(1);
    }

    @Test
    public void removeWithBrand_should_work_correctly() {
        Computer computer1 = new Computer(1, Brand.DELL, 2300, 15.6, "grey");
        Computer computer2 = new Computer(2, Brand.DELL, 2400, 15.6, "black");
        this.microsystems.createComputer(computer1);
        this.microsystems.createComputer(computer2);
        this.microsystems.removeWithBrand(Brand.DELL);
        assertFalse("Computers with brand DELL should be removed", this.microsystems.contains(1));
        assertFalse("Computers with brand DELL should be removed", this.microsystems.contains(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeWithBrand_should_throw_exception_if_not_exists() {
        this.microsystems.removeWithBrand(Brand.DELL);
    }

    @Test
    public void upgradeRam_should_work_correctly() {
        Computer computer = new Computer(1, Brand.DELL, 2300, 15.6, "grey");
        this.microsystems.createComputer(computer);
        this.microsystems.upgradeRam(16, 1);
        assertEquals("RAM should be upgraded", 16, this.microsystems.getComputer(1).getRAM());
    }

    @Test
    public void upgradeRam_should_not_downgrade_ram() {
        Computer computer = new Computer(1, Brand.DELL, 2300, 15.6, "grey");
        this.microsystems.createComputer(computer);
        this.microsystems.upgradeRam(4, 1);
        assertEquals("RAM should not be downgraded", 8, this.microsystems.getComputer(1).getRAM());
    }

    @Test(expected = IllegalArgumentException.class)
    public void upgradeRam_should_throw_exception_if_not_exists() {
        this.microsystems.upgradeRam(16, 1);
    }

    @Test
    public void getAllFromBrand_should_return_correct_computers() {
        Computer computer1 = new Computer(1, Brand.DELL, 2300, 15.6, "grey");
        Computer computer2 = new Computer(2, Brand.DELL, 2400, 15.6, "black");
        this.microsystems.createComputer(computer1);
        this.microsystems.createComputer(computer2);
        Iterable<Computer> computers = this.microsystems.getAllFromBrand(Brand.DELL);
        assertTrue("Should contain computer1", ((Collection<Computer>) computers).contains(computer1));
        assertTrue("Should contain computer2", ((Collection<Computer>) computers).contains(computer2));
    }

    @Test
    public void getAllWithScreenSize_should_return_correct_computers() {
        Computer computer1 = new Computer(1, Brand.DELL, 2300, 15.6, "grey");
        Computer computer2 = new Computer(2, Brand.HP, 2400, 15.6, "black");
        this.microsystems.createComputer(computer1);
        this.microsystems.createComputer(computer2);
        Iterable<Computer> computers = this.microsystems.getAllWithScreenSize(15.6);
        assertTrue("Should contain computer1", ((Collection<Computer>) computers).contains(computer1));
        assertTrue("Should contain computer2", ((Collection<Computer>) computers).contains(computer2));
    }

    @Test
    public void getAllWithColor_should_return_correct_computers() {
        Computer computer1 = new Computer(1, Brand.DELL, 2300, 15.6, "grey");
        Computer computer2 = new Computer(2, Brand.HP, 2400, 15.6, "grey");
        this.microsystems.createComputer(computer1);
        this.microsystems.createComputer(computer2);
        Iterable<Computer> computers = this.microsystems.getAllWithColor("grey");
        assertTrue("Should contain computer1", ((Collection<Computer>) computers).contains(computer1));
        assertTrue("Should contain computer2", ((Collection<Computer>) computers).contains(computer2));
    }

    @Test
    public void getInRangePrice_should_return_correct_computers() {
        Computer computer1 = new Computer(1, Brand.DELL, 2300, 15.6, "grey");
        Computer computer2 = new Computer(2, Brand.HP, 2400, 15.6, "black");
        this.microsystems.createComputer(computer1);
        this.microsystems.createComputer(computer2);
        Iterable<Computer> computers = this.microsystems.getInRangePrice(2000, 2500);
        assertTrue("Should contain computer1", ((Collection<Computer>) computers).contains(computer1));
        assertTrue("Should contain computer2", ((Collection<Computer>) computers).contains(computer2));
    }
}
