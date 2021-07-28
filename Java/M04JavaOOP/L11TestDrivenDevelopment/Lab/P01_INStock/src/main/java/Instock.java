import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private Map<String, Product> products;

    public Instock() {
        this.products = new LinkedHashMap<>();
    }

    @Override
    public Integer getCount() {
        return products.size();
    }

    @Override
    public Boolean contains(Product product) {
        return this.products.containsKey(product.getLabel());
    }

    @Override
    public void add(Product product) {
        if (!contains(product)) {
            this.products.put(product.getLabel(), product);

        }
    }

    @Override
    public void changeQuantity(String label, int quantity) {

        if (!products.containsKey(label)) {
            throw new IllegalArgumentException();
        }
        Product product = products.get(label);
        product.setQuantity(product.getQuantity() + quantity);
    }

    @Override
    public Product find(int index) {

        return new ArrayList<>(this.products.values()).get(index);
    }

    @Override
    public Product findByLabel(String label) {

        if (!products.containsKey(label)) {
            throw new IllegalArgumentException();
        }
        return products.get(label);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count > products.size() || count <= 0) {
            return new ArrayList<>();
        }
        return products.values().stream().sorted(Comparator.comparing(Product::getLabel)).limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {

        return products.values().stream().filter(e -> e.getPrice() > lo && e.getPrice() <= hi)
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return products.values().stream().filter(e->e.getPrice()==price).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {

        return null;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return null;
    }

    @Override
    public Iterator<Product> iterator() {

        return products.values().iterator();
    }
}