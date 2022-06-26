package bg.manhattan.shoppinglist.service.impl;

import bg.manhattan.shoppinglist.model.entity.Category;
import bg.manhattan.shoppinglist.model.entity.Product;
import bg.manhattan.shoppinglist.model.service.ProductServiceModel;
import bg.manhattan.shoppinglist.model.view.ShoppingItemViewModel;
import bg.manhattan.shoppinglist.model.view.ShoppingListViewModel;
import bg.manhattan.shoppinglist.repository.ProductRepository;
import bg.manhattan.shoppinglist.service.CategoryService;
import bg.manhattan.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final CategoryService categoryService;

    private final ModelMapper mapper;

    public ProductServiceImpl(ProductRepository repository,
                              CategoryService categoryService,
                              ModelMapper mapper) {
        this.repository = repository;
        this.categoryService = categoryService;
        this.mapper = mapper;
    }


    @Override
    public void addProduct(ProductServiceModel productModel) {
        Category category = this.categoryService
                .findByName(productModel.getCategory())
                .orElse(null);

        Product product = this.mapper.map(productModel, Product.class)
                .setCategory(category);

        this.repository.save(product);

    }

    @Override
    public ShoppingListViewModel getProducts() {
        return new ShoppingListViewModel(this.repository.findAllShoppingItems());
    }

    @Override
    public void buyProduct(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void buyAllProducts() {
        this.repository.deleteAll();
    }
}
