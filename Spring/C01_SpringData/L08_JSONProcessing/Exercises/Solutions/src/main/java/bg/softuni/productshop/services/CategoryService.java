package bg.softuni.productshop.services;

import bg.softuni.productshop.models.dtos.CategoriesByProductsDto;
import bg.softuni.productshop.models.entities.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> findRandomCategories();

    List<CategoriesByProductsDto> getAllCategoriesOrderByNumberOfProducts();
}
