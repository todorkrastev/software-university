package io.github.todorkrastev.coffeeshop.service;

import io.github.todorkrastev.coffeeshop.model.entity.Category;
import io.github.todorkrastev.coffeeshop.model.entity.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryName name);
}
