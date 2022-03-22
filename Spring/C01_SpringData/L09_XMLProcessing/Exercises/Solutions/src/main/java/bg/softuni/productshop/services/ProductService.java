package bg.softuni.productshop.services;

import bg.softuni.productshop.models.dtos.ProductSeedDto;
import bg.softuni.productshop.models.dtos.ProductViewRootDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    long getEntityCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductViewRootDto findAllProductsInRangeOrderByPrice(BigDecimal lowestPrice, BigDecimal highestPrice);
}
