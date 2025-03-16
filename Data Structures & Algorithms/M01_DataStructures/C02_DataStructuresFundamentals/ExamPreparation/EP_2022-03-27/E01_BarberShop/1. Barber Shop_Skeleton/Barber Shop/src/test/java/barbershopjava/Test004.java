package barbershopjava;

import barbershopjava.Barber;
import barbershopjava.BarberShopImpl;
import barbershopjava.Client;
import barbershopjava.Gender;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test004 {

    private BarberShopImpl barberShop;

    private Client c1 = new Client("a", 1, Gender.MALE);

    @Before
    public void Setup() {
        this.barberShop = new BarberShopImpl();
    }

    @Test
    public void TestAddClient() {
        this.barberShop.addClient(c1);
        assertTrue(this.barberShop.exist(c1));
    }
}