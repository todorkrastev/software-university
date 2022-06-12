package com.todorkrastev.shoppinglist.service.impl;

import com.todorkrastev.shoppinglist.model.entity.Category;
import com.todorkrastev.shoppinglist.model.entity.enums.CategoryName;
import com.todorkrastev.shoppinglist.repository.CategoryRepository;
import com.todorkrastev.shoppinglist.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category(categoryName,
                                "Description for " + categoryName.name());

                        this.categoryRepository.save(category);
                    });
        }
    }
}
