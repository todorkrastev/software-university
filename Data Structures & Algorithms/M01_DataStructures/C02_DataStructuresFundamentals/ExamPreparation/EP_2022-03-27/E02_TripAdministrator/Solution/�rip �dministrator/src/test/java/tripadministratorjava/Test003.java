package tripadministratorjava;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test003 {

    private TripAdministrationImpl tripAdministrations;

    private Company c1 = new Company("a", 2);
    private Company c2 = new Company("b", 1);
    private Company c3 = new Company("c", 1);

    @Before
    public void Setup() {
        this.tripAdministrations = new TripAdministrationImpl();
    }

    @Test
    public void TestAddManyCompanies() {
        this.tripAdministrations.addCompany(c1);
        this.tripAdministrations.addCompany(c2);
        this.tripAdministrations.addCompany(c3);

        assertEquals(3, this.tripAdministrations.getCompanies().size());
    }
}