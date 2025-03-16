package barbershopjava;

import barbershopjava.Barber;
import barbershopjava.BarberShopImpl;
import barbershopjava.Client;
import barbershopjava.Gender;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test001 {

    private BarberShopImpl barberShop;
    private Barber b1 = new Barber("a", 1, 1);

    @Before
    public void Setup() {
        this.barberShop = new BarberShopImpl();
    }

    @Test
    public void TestAddBarber() {
        this.barberShop.addBarber(b1);
        assertTrue(this.barberShop.exist(b1));
    }
}
