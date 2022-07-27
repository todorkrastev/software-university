package com.todorkrastev.andreysstore.service;

import com.todorkrastev.andreysstore.model.entity.Category;
import com.todorkrastev.andreysstore.model.entity.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    Category find(CategoryName categoryName);
}
