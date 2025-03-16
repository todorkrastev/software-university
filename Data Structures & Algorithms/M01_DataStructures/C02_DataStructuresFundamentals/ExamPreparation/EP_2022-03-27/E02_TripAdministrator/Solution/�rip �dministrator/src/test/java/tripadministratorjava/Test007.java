package tripadministratorjava;

import org.junit.Before;
import org.junit.Test;

public class Test007 {

    private TripAdministrationImpl tripAdministrations;
    private Company c2 = new Company("b", 1);
    private Trip t1 = new Trip("a", 1, tripadministratorjava.Transportation.NONE, 1);

    @Before
    public void Setup() {
        this.tripAdministrations = new TripAdministrationImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddTripForNonExistentCompany() {
        this.tripAdministrations.addTrip(c2, t1);
    }
}