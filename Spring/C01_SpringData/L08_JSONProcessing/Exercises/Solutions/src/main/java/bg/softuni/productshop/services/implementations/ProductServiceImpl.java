package bg.softuni.productshop.services.implementations;

import bg.softuni.productshop.constants.GlobalConstant;
import bg.softuni.productshop.models.dtos.ProductNameAndPriceDto;
import bg.softuni.productshop.models.dtos.ProductSeedDto;
import bg.softuni.productshop.models.entities.Product;
import bg.softuni.productshop.repositories.ProductRepository;
import bg.softuni.productshop.services.CategoryService;
import bg.softuni.productshop.services.ProductService;
import bg.softuni.productshop.services.UserService;
import bg.softuni.productshop.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    public static final String PRODUCTS_FILE_NAME = "products.json";
    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedProducts() throws IOException {
        if (this.productRepository.count() == 0) {
            String fileContent = Files
                    .readString(Path.of(GlobalConstant.RESOURCES_FILE_PATH + PRODUCTS_FILE_NAME));

            ProductSeedDto[] productSeedDtos = this.gson
                    .fromJson(fileContent, ProductSeedDto[].class);

            Arrays.stream(productSeedDtos)
                    .filter(this.validationUtil::isValid)
                    .map(productSeedDto -> {
                        Product product = this.modelMapper.map(productSeedDto, Product.class);
                        product.setSeller(this.userService.findRandomUser());

                        if (product.getPrice().compareTo(BigDecimal.valueOf(900L)) > 0) {
                            product.setBuyer(this.userService.findRandomUser());
                        }

                        product.setCategories(this.categoryService.findRandomCategories());

                        return product;
                    })
                    .forEach(this.productRepository::save);
        }
    }

    @Override
    public List<ProductNameAndPriceDto> findAllProductsInRangeOrderByPrice(BigDecimal lowestPrice, BigDecimal highestPrice) {
        return this.productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPriceDesc(lowestPrice, highestPrice)
                .stream()
                .map(product -> {
                    ProductNameAndPriceDto productNameAndPriceDto = modelMapper
                            .map(product, ProductNameAndPriceDto.class);

                    productNameAndPriceDto.setSeller(String.format("%s %s",
                            product.getSeller().getFirstName(),
                            product.getSeller().getLastName()));

                    return productNameAndPriceDto;
                })
                .collect(Collectors.toList());
    }
}
