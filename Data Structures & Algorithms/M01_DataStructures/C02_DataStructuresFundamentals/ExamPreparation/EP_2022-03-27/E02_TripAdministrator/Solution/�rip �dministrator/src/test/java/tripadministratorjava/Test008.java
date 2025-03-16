package tripadministratorjava;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test008 {

    private TripAdministrationImpl tripAdministrations;
    private Company c1 = new Company("a", 2);

    @Before
    public void Setup() {
        this.tripAdministrations = new TripAdministrationImpl();
    }

    @Test
    public void TestExistCompanyForNotAddingAnyCompany() {
        assertFalse(this.tripAdministrations.exist(c1));
    }
}