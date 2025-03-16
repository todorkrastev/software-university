package tripadministratorjava;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test001 {

    private TripAdministrationImpl tripAdministrations;

    private Company c1 = new Company("a", 2);

    @Before
    public void Setup() {
        this.tripAdministrations = new TripAdministrationImpl();
    }

    @Test
    public void TestAddCompany() {
        this.tripAdministrations.addCompany(c1);
        assertTrue(this.tripAdministrations.exist(c1));
    }
}