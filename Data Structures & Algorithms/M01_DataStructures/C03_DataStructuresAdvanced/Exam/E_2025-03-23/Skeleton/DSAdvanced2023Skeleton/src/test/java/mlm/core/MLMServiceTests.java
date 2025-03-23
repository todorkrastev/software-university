package mlm.core;

import mlm.models.Seller;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

public class MLMServiceTests {
    private MLMService service;

    private Seller seller = new Seller("first");

    @Before
    public void setup() {
        service = new MLMServiceImpl();
    }

    @Test
    public void addSeller() {
        service.addSeller(seller);

        assertTrue(service.exists(seller));
    }

    @Test
    public void hireSeller() {
        service.addSeller(seller);

        Seller second = new Seller("second");
        service.hireSeller(seller, second);

        assertTrue(service.exists(seller));
        assertTrue(service.exists(second));
    }

    @Test
    public void fire() {
        service.addSeller(seller);
        Seller hired = new Seller("hired");

        service.hireSeller(seller, hired);

        assertTrue(service.exists(seller));
        assertTrue(service.exists(hired));

        service.fire(hired);

        assertTrue(service.exists(seller));
        assertFalse(service.exists(hired));
    }

    @Test
    public void makeSaleWithoutParents() {
        service.addSeller(seller);

        service.makeSale(seller, 100);

        assertEquals(100, seller.earnings);
    }

    @Test
    public void getByProfitsEmpty() {
        Collection<Seller> sellers = service.getByProfits();
        assertTrue(sellers.isEmpty());
    }

    @Test
    public void getByProfitsSingleSeller() {
        Seller seller = new Seller("first");
        seller.earnings = 100;
        service.addSeller(seller);

        Collection<Seller> sellers = service.getByProfits();
        assertEquals(1, sellers.size());
        assertEquals(seller, sellers.iterator().next());
    }

    @Test
    public void getByProfitsMultipleSellers() {
        Seller seller1 = new Seller("first");
        seller1.earnings = 100;
        service.addSeller(seller1);

        Seller seller2 = new Seller("second");
        seller2.earnings = 200;
        service.addSeller(seller2);

        Seller seller3 = new Seller("third");
        seller3.earnings = 150;
        service.addSeller(seller3);

        Collection<Seller> sellers = service.getByProfits();
        assertEquals(3, sellers.size());

        Iterator<Seller> iterator = sellers.iterator();
        assertEquals(seller2, iterator.next());
        assertEquals(seller3, iterator.next());
        assertEquals(seller1, iterator.next());
    }

    @Test
    public void getByEmployeeCountEmpty() {
        Collection<Seller> sellers = service.getByEmployeeCount();
        assertTrue(sellers.isEmpty());
    }

    @Test
    public void getByEmployeeCountSingleSeller() {
        Seller seller = new Seller("first");
        service.addSeller(seller);

        Collection<Seller> sellers = service.getByEmployeeCount();
        assertEquals(1, sellers.size());
        assertEquals(seller, sellers.iterator().next());
    }

    @Test
    public void getByEmployeeCountMultipleSellers() {
        Seller sellerA = new Seller("A");
        service.addSeller(sellerA);

        Seller sellerB = new Seller("B");
        service.hireSeller(sellerA, sellerB);

        Seller sellerC = new Seller("C");
        Seller sellerD = new Seller("D");
        service.hireSeller(sellerB, sellerC);
        service.hireSeller(sellerB, sellerD);

        Collection<Seller> sellers = service.getByEmployeeCount();
        assertEquals(4, sellers.size());

        Iterator<Seller> iterator = sellers.iterator();
        assertEquals(sellerA, iterator.next());
        assertEquals(sellerB, iterator.next());
        assertEquals(sellerC, iterator.next());
        assertEquals(sellerD, iterator.next());
    }

    @Test
    public void getByEmployeeCountSameCountOrderByAddition() {
        Seller sellerA = new Seller("A");
        service.addSeller(sellerA);

        Seller sellerB = new Seller("B");
        service.hireSeller(sellerA, sellerB);

        Seller sellerC = new Seller("C");
        service.addSeller(sellerC);

        Collection<Seller> sellers = service.getByEmployeeCount();
        assertEquals(3, sellers.size());

        Iterator<Seller> iterator = sellers.iterator();
        assertEquals(sellerA, iterator.next());
        assertEquals(sellerB, iterator.next());
        assertEquals(sellerC, iterator.next());
    }


    @Test
    public void getByTotalSalesOnEmpty() {
        Collection<Seller> byTotalSalesMade = service.getByTotalSalesMade();

        assertTrue(byTotalSalesMade.isEmpty());
    }

    @Test
    public void getByTotalSalesMadeEmpty() {
        Collection<Seller> sellers = service.getByTotalSalesMade();
        assertTrue(sellers.isEmpty());
    }

    @Test
    public void getByTotalSalesMadeSingleSeller() {
        Seller seller = new Seller("first");
        service.addSeller(seller);

        service.makeSale(seller, 100);

        Collection<Seller> sellers = service.getByTotalSalesMade();
        assertEquals(1, sellers.size());
        assertEquals(seller, sellers.iterator().next());
    }

    @Test
    public void getByTotalSalesMadeMultipleSellers() {
        Seller seller1 = new Seller("first");
        service.addSeller(seller1);
        service.makeSale(seller1, 100);
        service.makeSale(seller1, 200);

        Seller seller2 = new Seller("second");
        service.addSeller(seller2);
        service.makeSale(seller2, 300);

        Seller seller3 = new Seller("third");
        service.addSeller(seller3);

        Collection<Seller> sellers = service.getByTotalSalesMade();
        assertEquals(3, sellers.size());

        Iterator<Seller> iterator = sellers.iterator();
        assertEquals(seller1, iterator.next());
        assertEquals(seller2, iterator.next());
        assertEquals(seller3, iterator.next());
    }
}
