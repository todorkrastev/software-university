package com.manhattan.services.productShop.interfaces;

import com.manhattan.models.productsShop.dtos.CategoriesByProductsRootDto;
import com.manhattan.models.productsShop.entities.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();

    void saveAll(Iterable<Category> cate);

    CategoriesByProductsRootDto getCategoriesOrderByNumberOfProducts();

    boolean hasNoRecords();
}
