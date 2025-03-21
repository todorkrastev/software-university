import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AgencyTest {
    private Agency agency;

    @Before
    public void setup() {
        this.agency = new AgencyImpl();
    }

    @Test
    public void test_contains_with_correct_data() {
        Invoice inv1 = new Invoice("1",
                "HRS",
                125D, Department.INCOMES,
                LocalDate.of(2018, 2, 12),
                LocalDate.of(2018, 3, 12));

        Invoice inv2 = new Invoice("2",
                "SoftUni",
                1000D, Department.INCOMES,
                LocalDate.of(2019, 2, 12),
                LocalDate.of(2019, 3, 12));

        this.agency.create(inv1);
        this.agency.create(inv2);

        final boolean expectedContains = this.agency.contains(inv1.getNumber()) &&
                this.agency.contains(inv2.getNumber()) &&
                !this.agency.contains("5");

        assertTrue("Incorrect contains behavior", expectedContains);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_create_must_throw_exception() {
        Invoice inv1 = new Invoice("1",
                "HRS",
                125D, Department.INCOMES,
                LocalDate.of(2018, 2, 12),
                LocalDate.of(2018, 3, 12));

        Invoice inv2 = new Invoice("1",
                "SoftUni",
                1000D, Department.INCOMES,
                LocalDate.of(2019, 2, 12),
                LocalDate.of(2019, 3, 12));

        this.agency.create(inv1);
        this.agency.create(inv2);
    }

    @Test
    public void test_create_only_with_contains_check() {
        Invoice inv1 = new Invoice("1",
                "HRS",
                125D, Department.INCOMES,
                LocalDate.of(2018, 2, 12),
                LocalDate.of(2018, 3, 12));

        Invoice inv2 = new Invoice("2",
                "SoftUni",
                1000D, Department.INCOMES,
                LocalDate.of(2019, 2, 12),
                LocalDate.of(2019, 3, 12));

        this.agency.create(inv1);
        this.agency.create(inv2);

        final boolean expectedContains = this.agency.contains(inv1.getNumber()) &&
                this.agency.contains(inv2.getNumber()) &&
                !this.agency.contains("5");

        assertTrue("Incorrect contains behavior", expectedContains);
    }

    @Test
    public void test_create() {
        Invoice inv1 = new Invoice("1",
                "HRS",
                125D, Department.INCOMES,
                LocalDate.of(2018, 2, 12),
                LocalDate.of(2018, 3, 12));

        Invoice inv2 = new Invoice("2",
                "SoftUni",
                1000D, Department.INCOMES,
                LocalDate.of(2019, 2, 12),
                LocalDate.of(2019, 3, 12));

        this.agency.create(inv1);
        this.agency.create(inv2);

        final int expectedCount = 2;
        final int actualCount = this.agency.count();

        assertEquals("Incorrect count", expectedCount, actualCount);

        final boolean expectedContains = this.agency.contains(inv1.getNumber()) &&
                this.agency.contains(inv2.getNumber()) &&
                !this.agency.contains("5");

        assertTrue("Incorrect contains behavior", expectedContains);
    }
}