package com.manhattan.services.interfaces;

import com.manhattan.entities.Category;

import java.util.Set;

public interface CategoryService {
    void registerCategory(Category category);

    Set<Category> getRandomCategories();
}
