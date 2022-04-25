package com.manhattan.services.productShop.implementations;

import com.manhattan.models.productsShop.dtos.ProductInRangeDto;
import com.manhattan.models.productsShop.entities.Product;
import com.manhattan.repositories.productShop.ProductRepository;
import com.manhattan.services.productShop.interfaces.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void saveAll(Iterable<Product> collect) {
        this.repository.saveAllAndFlush(collect);
    }

    @Override
    public Collection<ProductInRangeDto> getNotBoughtProductsWithPriceInRange(BigDecimal min, BigDecimal max) {
        return Set.of(
                mapper.map(
                        this.repository.findByBuyerIsNullAndPriceBetweenOrderByPriceDesc(min, max),
                        ProductInRangeDto[].class));
    }

    @Override
    public boolean hasNoRecords() {
        return this.repository.count() == 0;
    }
}
