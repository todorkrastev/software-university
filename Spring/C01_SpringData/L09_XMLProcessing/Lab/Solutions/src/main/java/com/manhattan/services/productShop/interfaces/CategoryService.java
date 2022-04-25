package com.manhattan.services.productShop.interfaces;

import com.manhattan.models.productsShop.dtos.CategoriesByProductsDto;
import com.manhattan.models.productsShop.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();

    void saveAll(Iterable<Category> cate);

    List<CategoriesByProductsDto> getCategoriesOrderByNumberOfProducts();
}
