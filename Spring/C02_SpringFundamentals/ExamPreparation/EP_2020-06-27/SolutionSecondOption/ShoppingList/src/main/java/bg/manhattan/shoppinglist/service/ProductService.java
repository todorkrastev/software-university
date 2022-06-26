package bg.manhattan.shoppinglist.service;

import bg.manhattan.shoppinglist.model.service.ProductServiceModel;
import bg.manhattan.shoppinglist.model.view.ShoppingListViewModel;

public interface ProductService {
    void addProduct(ProductServiceModel productModel);

    ShoppingListViewModel getProducts();

    void buyProduct(Long id);

    void buyAllProducts();
}
