package com.todorkrastev.shoppinglist.service;

import com.todorkrastev.shoppinglist.model.entity.Category;
import com.todorkrastev.shoppinglist.model.entity.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryName categoryName);
}
