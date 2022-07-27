package bg.manhattan.andreysshop.service.impl;

import bg.manhattan.andreysshop.model.entity.Product;
import bg.manhattan.andreysshop.model.service.ProductServiceModel;
import bg.manhattan.andreysshop.model.service.UserServiceModel;
import bg.manhattan.andreysshop.model.view.ProductDetailsViewModel;
import bg.manhattan.andreysshop.model.view.ProductViewModel;
import bg.manhattan.andreysshop.repository.ProductRepository;
import bg.manhattan.andreysshop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public void add(ProductServiceModel productModel) {
        Product product = this.mapper.map(productModel, Product.class);
        this.productRepository.save(product);
    }

    @Override
    public List<ProductViewModel> getProducts() {
        return this.productRepository.findAll()
                .stream()
                .map(product -> this.mapper.map(product, ProductViewModel.class))
                .toList();
    }

    @Override
    public Optional<ProductDetailsViewModel> getById(UUID id) {
        Optional<Product> product = this.productRepository.findById(id);
        return product.map(value -> this.mapper.map(value, ProductDetailsViewModel.class));
    }

    @Override
    public void delete(UUID id) {
        this.productRepository.deleteById(id);
    }
}
