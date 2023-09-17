package bg.manhattan.andreysshop.model.view;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel {
    private final List<ProductViewModel> products;

    public HomeViewModel() {
        this(new ArrayList<>());
    }

    public HomeViewModel(List<ProductViewModel> products) {
        this.products = products;
    }

    public List<ProductViewModel> getProducts() {
        return products;
    }
}
