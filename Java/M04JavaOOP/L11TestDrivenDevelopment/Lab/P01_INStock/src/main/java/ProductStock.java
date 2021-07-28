public interface ProductStock extends Iterable<Product> {

    Integer getCount();

    Boolean contains(Product product);

    void add(Product product);

    void changeQuantity(String product, int quantity);

    Product find(int index);

    Product findByLabel(String label);

    Iterable<Product> findFirstByAlphabeticalOrder(int count);

    Iterable<Product> findAllInRange(double lo, double hi);

    Iterable<Product> findAllByPrice(double price);

    Iterable<Product> findFirstMostExpensiveProducts(int count);

    Iterable<Product> findAllByQuantity(int quantity);
}