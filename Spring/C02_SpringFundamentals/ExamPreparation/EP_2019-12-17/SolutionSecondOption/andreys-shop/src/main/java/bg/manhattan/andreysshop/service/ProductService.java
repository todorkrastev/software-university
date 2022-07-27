package bg.manhattan.andreysshop.service;

import bg.manhattan.andreysshop.model.service.ProductServiceModel;
import bg.manhattan.andreysshop.model.view.ProductDetailsViewModel;
import bg.manhattan.andreysshop.model.view.ProductViewModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    void add(ProductServiceModel productModel);

    List<ProductViewModel> getProducts();

    Optional<ProductDetailsViewModel> getById(UUID id);

    void delete(UUID id);
}
