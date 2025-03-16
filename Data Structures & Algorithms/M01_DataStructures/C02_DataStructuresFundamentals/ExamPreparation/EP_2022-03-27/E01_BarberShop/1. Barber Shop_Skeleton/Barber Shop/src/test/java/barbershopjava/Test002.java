package barbershopjava;

import barbershopjava.Barber;
import barbershopjava.BarberShopImpl;
import barbershopjava.Client;
import barbershopjava.Gender;

import org.junit.Before;
import org.junit.Test;

public class Test002 {

    private BarberShopImpl barberShop;
    private Barber b1 = new Barber("a", 1, 1);

    @Before
    public void Setup() {
        this.barberShop = new BarberShopImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddBarberTwice() {
        this.barberShop.addBarber(b1);
        this.barberShop.addBarber(b1);
    }
}