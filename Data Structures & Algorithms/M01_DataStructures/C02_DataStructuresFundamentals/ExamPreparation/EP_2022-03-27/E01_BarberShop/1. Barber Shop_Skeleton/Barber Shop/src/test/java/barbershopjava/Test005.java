package barbershopjava;

import barbershopjava.Barber;
import barbershopjava.BarberShopImpl;
import barbershopjava.Client;
import barbershopjava.Gender;

import org.junit.Before;
import org.junit.Test;

public class Test005 {

    private BarberShopImpl barberShop;
    private Client c1 = new Client("a", 1, Gender.MALE);

    @Before
    public void Setup() {
        this.barberShop = new BarberShopImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddClientTwice() {
        this.barberShop.addClient(c1);
        this.barberShop.addClient(c1);
    }
}