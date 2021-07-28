

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;

public class ProductStockTest {

    private ProductStock instock;

    @Before
    public void SetUp() {
        instock = new Instock();
    }

    @Test
    public void testGetCountMustReturnCorrectCountOfAddedProducts() {
        addFiveProducts();
        assertEquals(Integer.valueOf(5), instock.getCount());
    }

    @Test
    public void testGetCountMustReturnZeroWhenCollectionIsEmpty() {

        assertEquals(Integer.valueOf(0), instock.getCount());
    }

    @Test
    public void testAddMustStoreTheProductByValidatingWhitContains() {

        Product product = createTestProduct();
        instock.add(product);
        Boolean contains = instock.contains(product);
        assertNotNull(contains);
        assertTrue(contains);
    }

    @Test
    public void testAddShouldNotAddSameProductTwice() {

        Product product = createTestProduct();
        instock.add(product);
        instock.add(product);
        Integer count = instock.getCount();
        assertNotNull(count);
        assertEquals(Integer.valueOf(1), count);
    }

    @Test
    public void testContainsMustReturnFalseWhenProductIsNotPresent() {

        addFiveProducts();
        Boolean contains = instock.contains(createTestProduct());
        assertNotNull(contains);
        assertFalse(contains);
    }

    @Test
    public void testContainsMustReturnFalseWhenCollectionIsEmpty() {

        Boolean contains = instock.contains(createTestProduct());
        assertNotNull(contains);
        assertFalse(contains);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindMustFailsIfIndexIsNegative() {

        instock.find(-1);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindMustFailsIfIndexEqualsToCount() {

        addFiveProducts();
        instock.find(instock.getCount());

    }

    @Test
    public void testFindShouldReturnFirstAddedProduct() {

        assertFindShouldReturnCorrectProduct(0);

    }

    @Test
    public void testFindShouldReturnLastAddedProduct() {

        assertFindShouldReturnCorrectProduct(4);

    }

    @Test
    public void testFindShouldReturnCorrectProductAtGivenIndex() {

        assertFindShouldReturnCorrectProduct(2);

    }

    @Test
    public void testChangeQuantityMustUpdateQuantityValue() {

        Product product = createTestProduct();
        instock.add(product);
        int quantityBeforeUpdate = product.getQuantity();
        instock.changeQuantity(product.getLabel(), 10);
        assertEquals(quantityBeforeUpdate + 10, product.getQuantity());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityMustFailWhenProductIsNotPresent() {

        addFiveProducts();
        instock.changeQuantity(createTestProduct().getLabel(), 10);

    }

    @Test
    public void testFindByLabelMustReturnCorrectProductByGivenLabel() {

        addFiveProducts();
        Product product = createTestProduct();
        String label = product.getLabel();
        instock.add(product);
        assertEquals(product, instock.findByLabel(label));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelMustFailWhenLabelNotExist() {

        addFiveProducts();
        instock.findByLabel("test_label");

    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnCorrectNumbersOfSortedProducts() {

        addFiveProducts();
        Product product = createTestProduct();
        instock.add(product);
        List<Product> productList = (List<Product>) instock.findFirstByAlphabeticalOrder(4);
        assertEquals(4, productList.size());
        assertEquals("test_label", productList.get(0).getLabel());
        assertEquals("test_label_1", productList.get(1).getLabel());
        assertEquals("test_label_2", productList.get(2).getLabel());
        assertEquals("test_label_3", productList.get(3).getLabel());

    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionIfThePassedArgumentIsMoreThanAddProducts() {

        addFiveProducts();
        List<Product> products = (List<Product>) instock.findFirstByAlphabeticalOrder(6);
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollectionIfThePassedArgumentIsLessOrEqualsZero() {

        addFiveProducts();
        List<Product> products = (List<Product>) instock.findFirstByAlphabeticalOrder(0);
        assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllInRangeShouldReturnEmptyCollectionIfNoSuchProductWhitPriceInThatRange() {

        addFiveProducts();
        List<Product> products = (List<Product>) instock.findAllInRange(10, 11);
        assertTrue(products.isEmpty());

    }

    @Test
    public void testFindAllInRangeShouldReturnAllProductsWhitPriceInGivenRangeSortedDescending() {

        addFiveProducts();
        double expectedFirst = 100.3;
        double expectedSecond = 100.2;
        List<Product> products = (List<Product>) instock.findAllInRange(100.1, 100.3);
        assertEquals(2, products.size());
        assertEquals(expectedFirst, products.get(0).getPrice(), 0.0);
        assertEquals(expectedSecond, products.get(1).getPrice(), 0.0);

    }

    @Test
    public void testFindAllByPriceShouldReturnAllProductsWhitGivenPrice() {

        addFiveProducts();
        Product product = createTestProduct();
        double price = product.getPrice();
        instock.add(product);
        List<Product> products = (List<Product>) instock.findAllByPrice(price);
        assertEquals(2, products.size());
        assertTrue(products.stream().allMatch(e -> e.getPrice() == price));
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionIfNotSuchProductWhitGivenPrice() {

        addFiveProducts();
        List<Product> products = (List<Product>) instock.findAllByPrice(10);
        assertTrue(products.isEmpty());

    }

    @Test
    public void testFindFirstMostExpensiveProductsMustReturnCorrectNumbersOfProducts() {

    }


    private void assertFindShouldReturnCorrectProduct(int index) {
        addFiveProducts();
        Product product = instock.find(index);
        assertNotNull(product);
        assertEquals("test_label_" + (index + 1), product.getLabel());
    }

    private void addFiveProducts() {
        instock.add(new Product("test_label_1", 100.0, 1));
        instock.add(new Product("test_label_2", 100.1, 2));
        instock.add(new Product("test_label_3", 100.2, 3));
        instock.add(new Product("test_label_4", 100.3, 4));
        instock.add(new Product("test_label_5", 100.4, 5));
    }

    private Product createTestProduct() {
        return new Product("test_label", 100.0, 1);
    }
}