package com.todorkrastev.andreysstore.service;

import com.todorkrastev.andreysstore.model.entity.enums.CategoryName;
import com.todorkrastev.andreysstore.model.service.CategoryServiceModel;

public interface CategoryService {
    void initCategories();

    CategoryServiceModel findByCategoryName(CategoryName categoryName);
}
