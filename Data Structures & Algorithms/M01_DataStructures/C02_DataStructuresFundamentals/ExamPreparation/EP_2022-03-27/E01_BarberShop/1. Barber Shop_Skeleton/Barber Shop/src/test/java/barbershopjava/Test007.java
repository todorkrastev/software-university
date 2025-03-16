package barbershopjava;

import barbershopjava.Barber;
import barbershopjava.BarberShopImpl;
import barbershopjava.Client;
import barbershopjava.Gender;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test007 {

    private BarberShopImpl barberShop;
    private Barber b1 = new Barber("a", 1, 1);

    @Before
    public void Setup() {
        this.barberShop = new BarberShopImpl();
    }

    @Test
    public void TestAddBarberPerf() {

        for (int i = 0; i < 10000; i++) {
            this.barberShop.addBarber(new Barber(i + "", i, i));
        }
        long start = System.currentTimeMillis();
        this.barberShop.addBarber(b1);
        long stop = System.currentTimeMillis();
        assertTrue(stop - start <=20);
    }
}