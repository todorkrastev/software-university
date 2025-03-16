package barbershopjava;

import barbershopjava.Barber;
import barbershopjava.BarberShopImpl;
import barbershopjava.Client;
import barbershopjava.Gender;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test008 {

    private BarberShopImpl barberShop;
    private Client c1 = new Client("a", 1, Gender.MALE);

    @Before
    public void Setup() {
        this.barberShop = new BarberShopImpl();
    }

    @Test
    public void TestAddBClientPerf() {
        for (int i = 0; i < 10000; i++) {
            this.barberShop.addClient(new Client(i + "", i, Gender.MALE));
        }
        long start = System.currentTimeMillis();
        this.barberShop.addClient(c1);
        long stop = System.currentTimeMillis();
        assertTrue(stop - start <=20);
    }
}