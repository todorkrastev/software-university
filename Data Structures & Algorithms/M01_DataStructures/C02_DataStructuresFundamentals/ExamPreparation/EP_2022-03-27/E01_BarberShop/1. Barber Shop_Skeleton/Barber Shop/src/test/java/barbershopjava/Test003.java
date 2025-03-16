package barbershopjava;

import barbershopjava.Barber;
import barbershopjava.BarberShopImpl;
import barbershopjava.Client;
import barbershopjava.Gender;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Test003 {

    private BarberShopImpl barberShop;
    private Barber b1 = new Barber("a", 1, 1);
    private Barber b2 = new Barber("b", 2, 3);

    @Before
    public void Setup() {
        this.barberShop = new BarberShopImpl();
    }

    @Test
    public void TestAddManyBarbers() {
        this.barberShop.addBarber(b1);
        this.barberShop.addBarber(b2);

        assertTrue(this.barberShop.getBarbers().size() == 2);
    }
}