package barbershopjava;

import barbershopjava.Barber;
import barbershopjava.BarberShopImpl;
import barbershopjava.Client;
import barbershopjava.Gender;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test006 {

    private BarberShopImpl barberShop;
    private Client c1 = new Client("a", 1, Gender.MALE);
    private Client c2 = new Client("b", 1, Gender.FEMALE);

    @Before
    public void Setup() {
        this.barberShop = new BarberShopImpl();
    }

    @Test
    public void TestAddManyClients() {
        this.barberShop.addClient(c1);
        this.barberShop.addClient(c2);

        assertTrue(this.barberShop.getClients().size() == 2);
    }
}