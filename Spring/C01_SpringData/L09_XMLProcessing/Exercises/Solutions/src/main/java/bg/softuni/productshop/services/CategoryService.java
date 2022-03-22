package bg.softuni.productshop.services;

import bg.softuni.productshop.models.dtos.CategorySeedDto;
import bg.softuni.productshop.models.dtos.CategoryViewRootDto;
import bg.softuni.productshop.models.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    long getEntityCount();

    void seedCategories(List<CategorySeedDto> categories);

    Set<Category> getRandomCategories();

    CategoryViewRootDto getAllCategoriesOrderByNumberOfProducts();
}
