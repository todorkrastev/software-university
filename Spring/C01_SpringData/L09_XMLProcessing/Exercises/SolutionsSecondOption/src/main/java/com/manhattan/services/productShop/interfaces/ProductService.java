package com.manhattan.services.productShop.interfaces;

import com.manhattan.models.productsShop.dtos.ProductsInRangeDto;
import com.manhattan.models.productsShop.dtos.ProductsInRangeRootDto;
import com.manhattan.models.productsShop.entities.Product;

import java.math.BigDecimal;

public interface ProductService {
    void saveAll(Iterable<Product> collect);
    ProductsInRangeRootDto getNotBoughtProductsWithPriceInRange(BigDecimal min, BigDecimal max);

    boolean hasNoRecords();
}
