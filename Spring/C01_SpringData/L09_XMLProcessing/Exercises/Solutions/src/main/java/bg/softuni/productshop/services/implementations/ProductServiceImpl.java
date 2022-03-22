package bg.softuni.productshop.services.implementations;

import bg.softuni.productshop.models.dtos.ProductSeedDto;
import bg.softuni.productshop.models.dtos.ProductViewRootDto;
import bg.softuni.productshop.models.dtos.ProductViewWithSellerDto;
import bg.softuni.productshop.models.entities.Product;
import bg.softuni.productshop.repositories.ProductRepository;
import bg.softuni.productshop.services.CategoryService;
import bg.softuni.productshop.services.ProductService;
import bg.softuni.productshop.services.UserService;
import bg.softuni.productshop.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public long getEntityCount() {
        return this.productRepository.count();
    }

    @Override
    public void seedProducts(List<ProductSeedDto> products) {
        products
                .stream()
                .filter(this.validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = this.modelMapper.map(productSeedDto, Product.class);

                    product.setSeller(this.userService.getRandomUser());

                    if (product.getPrice().compareTo(BigDecimal.valueOf(900L)) > 0) {
                        product.setBuyer(this.userService.getRandomUser());
                    }

                    product.setCategories(this.categoryService.getRandomCategories());

                    return product;
                })
                .forEach(this.productRepository::save);
    }

    @Override
    public ProductViewRootDto findAllProductsInRangeOrderByPrice(BigDecimal lowestPrice, BigDecimal highestPrice) {
        ProductViewRootDto productViewRootDto = new ProductViewRootDto();

        List<ProductViewWithSellerDto> productViewWithSellerDtoList = this.productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(lowestPrice, highestPrice)
                .stream()
                .map(product -> {
                    ProductViewWithSellerDto productViewWithSellerDto = this.modelMapper.map(product, ProductViewWithSellerDto.class);

                    productViewWithSellerDto
                            .setSeller(String.format("%s %s",
                                            product.getSeller().getFirstName() == null ? "" : product.getSeller().getFirstName(),
                                            product.getSeller().getLastName() == null ? "" : product.getSeller().getLastName())
                                    .trim());

                    return productViewWithSellerDto;
                })
                .collect(Collectors.toList());

        productViewRootDto.setProducts(productViewWithSellerDtoList);

        return productViewRootDto;
    }
}
