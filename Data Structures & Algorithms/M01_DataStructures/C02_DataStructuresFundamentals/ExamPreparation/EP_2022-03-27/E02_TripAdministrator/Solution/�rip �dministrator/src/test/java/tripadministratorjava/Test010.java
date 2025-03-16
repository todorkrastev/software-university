package tripadministratorjava;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test010 {

    private TripAdministrationImpl tripAdministrations;
    private Trip t1 = new Trip("a", 1, tripadministratorjava.Transportation.NONE, 1);

    @Before
    public void Setup() {
        this.tripAdministrations = new TripAdministrationImpl();
    }

    @Test
    public void TestAddTripPerf() {
        var nc = new Company("0", 100000);
        this.tripAdministrations.addCompany(nc);
        for (int i = 0; i < 10000; i++) {
            this.tripAdministrations.addTrip(nc, new Trip(i + "", i, tripadministratorjava.Transportation.NONE, i));
        }

        long start = System.currentTimeMillis();
        this.tripAdministrations.addTrip(nc, t1);
        long stop = System.currentTimeMillis();
        assertTrue(stop - start <= 20);
    }
}