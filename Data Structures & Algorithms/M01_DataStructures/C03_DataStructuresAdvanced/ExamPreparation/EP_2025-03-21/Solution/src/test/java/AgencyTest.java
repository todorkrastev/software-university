import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

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

    @Test
    public void test_payInvoice_should_set_subtotal_to_zero() {
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

        this.agency.payInvoice(LocalDate.of(2018, 3, 12));

        assertEquals("Subtotal should be zero", 0, inv1.getSubtotal(), 0.01);
        assertEquals("Subtotal should not change", 1000D, inv2.getSubtotal(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_payInvoice_should_throw_exception_if_no_invoices_found() {
        this.agency.payInvoice(LocalDate.of(2020, 1, 1));
    }


    @Test
    public void test_throwInvoice_should_remove_invoice() {
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

        this.agency.throwInvoice("1");

        assertFalse("Invoice should be removed", this.agency.contains("1"));
        assertTrue("Invoice should still exist", this.agency.contains("2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_throwInvoice_should_throw_exception_if_not_exists() {
        this.agency.throwInvoice("1");
    }

    @Test
    public void test_throwPayed_should_not_remove_unpayed_invoices() {
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

        this.agency.throwPayed();

        assertTrue("Unpayed invoice should still exist", this.agency.contains("1"));
        assertTrue("Unpayed invoice should still exist", this.agency.contains("2"));
    }

    @Test
    public void test_getAllInvoiceInPeriod_should_return_invoices_in_period() {
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

        Invoice inv3 = new Invoice("3",
                "Google",
                500D, Department.INCOMES,
                LocalDate.of(2020, 2, 12),
                LocalDate.of(2020, 3, 12));

        this.agency.create(inv1);
        this.agency.create(inv2);
        this.agency.create(inv3);

        Iterable<Invoice> result = this.agency.getAllInvoiceInPeriod(LocalDate.of(2018, 1, 1), LocalDate.of(2019, 12, 31));
        List<Invoice> resultList = (List<Invoice>) result;

        assertEquals("Should return 2 invoices", 2, resultList.size());
        assertTrue("Should contain inv1", resultList.contains(inv1));
        assertTrue("Should contain inv2", resultList.contains(inv2));
    }

    @Test
    public void test_getAllInvoiceInPeriod_should_return_empty_if_no_invoices_in_period() {
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

        Iterable<Invoice> result = this.agency.getAllInvoiceInPeriod(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 12, 31));
        List<Invoice> resultList = (List<Invoice>) result;

        assertTrue("Should return empty list", resultList.isEmpty());
    }

    @Test
    public void test_searchByNumber_should_return_matching_invoices() {
        Invoice inv1 = new Invoice("123",
                "HRS",
                125D, Department.INCOMES,
                LocalDate.of(2018, 2, 12),
                LocalDate.of(2018, 3, 12));

        Invoice inv2 = new Invoice("456",
                "SoftUni",
                1000D, Department.INCOMES,
                LocalDate.of(2019, 2, 12),
                LocalDate.of(2019, 3, 12));

        Invoice inv3 = new Invoice("1234",
                "Google",
                500D, Department.INCOMES,
                LocalDate.of(2020, 2, 12),
                LocalDate.of(2020, 3, 12));

        this.agency.create(inv1);
        this.agency.create(inv2);
        this.agency.create(inv3);

        Iterable<Invoice> result = this.agency.searchByNumber("123");
        List<Invoice> resultList = (List<Invoice>) result;

        assertEquals("Should return 2 invoices", 2, resultList.size());
        assertTrue("Should contain inv1", resultList.contains(inv1));
        assertTrue("Should contain inv3", resultList.contains(inv3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_searchByNumber_should_throw_exception_if_no_invoices_found() {
        this.agency.searchByNumber("999");
    }

    @Test
    public void test_throwInvoiceInPeriod_should_remove_invoices_in_period() {
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

        Invoice inv3 = new Invoice("3",
                "Google",
                500D, Department.INCOMES,
                LocalDate.of(2020, 2, 12),
                LocalDate.of(2020, 3, 12));

        this.agency.create(inv1);
        this.agency.create(inv2);
        this.agency.create(inv3);

        Iterable<Invoice> removedInvoices = this.agency.throwInvoiceInPeriod(LocalDate.of(2018, 1, 1), LocalDate.of(2019, 12, 31));
        List<Invoice> removedList = (List<Invoice>) removedInvoices;

        assertEquals("Should remove 2 invoices", 2, removedList.size());
        assertTrue("Should contain inv1", removedList.contains(inv1));
        assertTrue("Should contain inv2", removedList.contains(inv2));
        assertFalse("Should not contain inv3", removedList.contains(inv3));
        assertFalse("inv1 should be removed from agency", this.agency.contains("1"));
        assertFalse("inv2 should be removed from agency", this.agency.contains("2"));
        assertTrue("inv3 should still exist in agency", this.agency.contains("3"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_throwInvoiceInPeriod_should_throw_exception_if_no_invoices_in_period() {
        Invoice inv1 = new Invoice("1",
                "HRS",
                125D, Department.INCOMES,
                LocalDate.of(2018, 2, 12),
                LocalDate.of(2018, 3, 12));

        this.agency.create(inv1);

        this.agency.throwInvoiceInPeriod(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 12, 31));
    }

    @Test
    public void test_getAllFromDepartment_should_return_invoices_from_department() {
        Invoice inv1 = new Invoice("1",
                "HRS",
                125D, Department.INCOMES,
                LocalDate.of(2018, 2, 12),
                LocalDate.of(2018, 3, 12));

        Invoice inv2 = new Invoice("2",
                "SoftUni",
                1000D, Department.WASTAGE,
                LocalDate.of(2019, 2, 12),
                LocalDate.of(2019, 3, 12));

        Invoice inv3 = new Invoice("3",
                "Google",
                500D, Department.INCOMES,
                LocalDate.of(2020, 2, 12),
                LocalDate.of(2020, 3, 12));

        this.agency.create(inv1);
        this.agency.create(inv2);
        this.agency.create(inv3);

        Iterable<Invoice> result = this.agency.getAllFromDepartment(Department.INCOMES);
        List<Invoice> resultList = (List<Invoice>) result;

        assertEquals("Should return 2 invoices", 2, resultList.size());
        assertTrue("Should contain inv1", resultList.contains(inv1));
        assertTrue("Should contain inv3", resultList.contains(inv3));
    }

    @Test
    public void test_getAllFromDepartment_should_return_empty_if_no_invoices_from_department() {
        Invoice inv1 = new Invoice("1",
                "HRS",
                125D, Department.WASTAGE,
                LocalDate.of(2018, 2, 12),
                LocalDate.of(2018, 3, 12));

        Invoice inv2 = new Invoice("2",
                "SoftUni",
                1000D, Department.WASTAGE,
                LocalDate.of(2019, 2, 12),
                LocalDate.of(2019, 3, 12));

        this.agency.create(inv1);
        this.agency.create(inv2);

        Iterable<Invoice> result = this.agency.getAllFromDepartment(Department.INCOMES);
        List<Invoice> resultList = (List<Invoice>) result;

        assertTrue("Should return empty list", resultList.isEmpty());
    }

    @Test
    public void test_getAllByCompany_should_return_invoices_by_company() {
        Invoice inv1 = new Invoice("1",
                "HRS",
                125D, Department.INCOMES,
                LocalDate.of(2018, 2, 12),
                LocalDate.of(2018, 3, 12));

        Invoice inv2 = new Invoice("2",
                "SoftUni",
                1000D, Department.WASTAGE,
                LocalDate.of(2019, 2, 12),
                LocalDate.of(2019, 3, 12));

        Invoice inv3 = new Invoice("3",
                "HRS",
                500D, Department.INCOMES,
                LocalDate.of(2020, 2, 12),
                LocalDate.of(2020, 3, 12));

        this.agency.create(inv1);
        this.agency.create(inv2);
        this.agency.create(inv3);

        Iterable<Invoice> result = this.agency.getAllByCompany("HRS");
        List<Invoice> resultList = (List<Invoice>) result;

        assertEquals("Should return 2 invoices", 2, resultList.size());
        assertTrue("Should contain inv1", resultList.contains(inv1));
        assertTrue("Should contain inv3", resultList.contains(inv3));
    }

    @Test
    public void test_getAllByCompany_should_return_empty_if_no_invoices_by_company() {
        Invoice inv1 = new Invoice("1",
                "HRS",
                125D, Department.INCOMES,
                LocalDate.of(2018, 2, 12),
                LocalDate.of(2018, 3, 12));

        Invoice inv2 = new Invoice("2",
                "SoftUni",
                1000D, Department.WASTAGE,
                LocalDate.of(2019, 2, 12),
                LocalDate.of(2019, 3, 12));

        this.agency.create(inv1);
        this.agency.create(inv2);

        Iterable<Invoice> result = this.agency.getAllByCompany("Google");
        List<Invoice> resultList = (List<Invoice>) result;

        assertTrue("Should return empty list", resultList.isEmpty());
    }

    @Test
    public void test_extendDeadline_should_extend_due_date() {
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

        this.agency.extendDeadline(LocalDate.of(2018, 3, 12), 10);

        assertEquals("Due date should be extended by 10 days", LocalDate.of(2018, 3, 22), inv1.getDueDate());
        assertEquals("Due date should not change", LocalDate.of(2019, 3, 12), inv2.getDueDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_extendDeadline_should_throw_exception_if_no_invoices_found() {
        this.agency.extendDeadline(LocalDate.of(2020, 1, 1), 10);
    }

    @Test
    public void test_create_should_add_invoice() {
        Invoice inv1 = new Invoice("1", "HRS", 125D, Department.INCOMES, LocalDate.of(2018, 2, 12), LocalDate.of(2018, 3, 12));
        this.agency.create(inv1);
        assertTrue(this.agency.contains("1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_create_should_throw_exception_if_invoice_exists() {
        Invoice inv1 = new Invoice("1", "HRS", 125D, Department.INCOMES, LocalDate.of(2018, 2, 12), LocalDate.of(2018, 3, 12));
        this.agency.create(inv1);
        this.agency.create(inv1); // Should throw exception
    }

    @Test
    public void test_contains_should_return_true_if_invoice_exists() {
        Invoice inv1 = new Invoice("1", "HRS", 125D, Department.INCOMES, LocalDate.of(2018, 2, 12), LocalDate.of(2018, 3, 12));
        this.agency.create(inv1);
        assertTrue(this.agency.contains("1"));
    }

    @Test
    public void test_contains_should_return_false_if_invoice_does_not_exist() {
        assertFalse(this.agency.contains("1"));
    }

    @Test
    public void test_count_should_return_correct_number_of_invoices() {
        Invoice inv1 = new Invoice("1", "HRS", 125D, Department.INCOMES, LocalDate.of(2018, 2, 12), LocalDate.of(2018, 3, 12));
        Invoice inv2 = new Invoice("2", "SoftUni", 1000D, Department.INCOMES, LocalDate.of(2019, 2, 12), LocalDate.of(2019, 3, 12));
        this.agency.create(inv1);
        this.agency.create(inv2);
        assertEquals(2, this.agency.count());
    }

    @Test
    public void test_searchBySerialNumber_should_return_matching_invoices() {
        Invoice inv1 = new Invoice("123", "HRS", 125D, Department.INCOMES, LocalDate.of(2018, 2, 12), LocalDate.of(2018, 3, 12));
        Invoice inv2 = new Invoice("1234", "Google", 500D, Department.INCOMES, LocalDate.of(2020, 2, 12), LocalDate.of(2020, 3, 12));
        this.agency.create(inv1);
        this.agency.create(inv2);
        Iterable<Invoice> result = this.agency.searchByNumber("123");
        List<Invoice> resultList = (List<Invoice>) result;
        assertEquals(2, resultList.size());
        assertTrue(resultList.contains(inv1));
        assertTrue(resultList.contains(inv2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_searchBySerialNumber_should_throw_exception_if_no_invoices_found() {
        this.agency.searchByNumber("999");
    }
}