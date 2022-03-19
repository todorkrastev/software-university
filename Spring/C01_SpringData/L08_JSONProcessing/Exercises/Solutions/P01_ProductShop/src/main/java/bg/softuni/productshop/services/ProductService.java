package bg.softuni.productshop.services;

import bg.softuni.productshop.models.dtos.ProductNameAndPriceDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;

    List<ProductNameAndPriceDto> findAllProductsInRangeOrderByPrice(BigDecimal lowestPrice, BigDecimal highestPrice);
}
