package com.manhattan.repositories.productShop;

import com.manhattan.models.productsShop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Set<Product> findByBuyerIsNullAndPriceBetweenOrderByPriceDesc(BigDecimal min, BigDecimal max);
}
