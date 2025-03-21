import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MicrosystemTest {
    private Microsystem microsystem;

    @Before
    public void setUp() {
        this.microsystem = new MicrosystemImpl();
    }

    @Test
    public void count_should_work_correctly() {

        Computer computer1 = new Computer(2, Brand.ACER, 1120, 15.6, "grey");
        Computer computer = new Computer(1, Brand.DELL, 2300, 15.6, "grey");
        Computer computer2 = new Computer(5, Brand.HP, 2400, 13.6, "red");


        this.microsystem.createComputer(computer);
        this.microsystem.createComputer(computer1);
        this.microsystem.createComputer(computer2);

        final int expectedCount = 3;
        final int actualCount = this.microsystem.count();

        assertEquals("Incorrect count", expectedCount, actualCount);
    }

    @Test
    public void createComputer_should_return_true_with_valid_number() {

        Computer computer1 = new Computer(2, Brand.ACER, 1120, 15.6, "grey");
        Computer computer = new Computer(1, Brand.DELL, 2300, 15.6, "grey");


        this.microsystem.createComputer(computer);
        this.microsystem.createComputer(computer1);

        assertTrue("Incorrect return value", this.microsystem.contains(1));
        assertTrue("Incorrect return value", this.microsystem.contains(2));
    }

    @Test
    public void createComputer_should_increase_count() {
        Computer computer1 = new Computer(1, Brand.ACER, 1120, 15.6, "grey");
        Computer computer2 = new Computer(2, Brand.ASUS, 2000, 15.6, "red");

        this.microsystem.createComputer(computer1);
        this.microsystem.createComputer(computer2);
        final int expectedCount = 2;
        final int actualCount = this.microsystem.count();

        assertEquals("Incorrect count", expectedCount, actualCount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createComputer_should_throw_exception() {

        Computer computer = new Computer(1, Brand.ASUS, 10D, 13.3, "red");
        Computer computer1 = new Computer(1, Brand.DELL, 11D, 14.3, "black");

        this.microsystem.createComputer(computer);
        this.microsystem.createComputer(computer1);
    }
}