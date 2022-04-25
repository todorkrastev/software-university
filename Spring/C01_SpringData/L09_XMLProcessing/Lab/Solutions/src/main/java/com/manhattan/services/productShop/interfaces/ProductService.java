package com.manhattan.services.productShop.interfaces;

import com.manhattan.models.productsShop.dtos.ProductInRangeDto;
import com.manhattan.models.productsShop.entities.Product;

import java.math.BigDecimal;
import java.util.Collection;

public interface ProductService {
    void saveAll(Iterable<Product> collect);
    Collection<ProductInRangeDto> getNotBoughtProductsWithPriceInRange(BigDecimal min, BigDecimal max);

    boolean hasNoRecords();
}
