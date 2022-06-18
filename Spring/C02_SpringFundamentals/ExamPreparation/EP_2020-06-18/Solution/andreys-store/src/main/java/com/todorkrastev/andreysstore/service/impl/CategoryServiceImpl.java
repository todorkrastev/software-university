package com.todorkrastev.andreysstore.service.impl;

import com.todorkrastev.andreysstore.model.entity.Category;
import com.todorkrastev.andreysstore.model.entity.enums.CategoryName;
import com.todorkrastev.andreysstore.repository.CategoryRepository;
import com.todorkrastev.andreysstore.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void initCategories() {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> this.categoryRepository
                            .save(new Category(categoryName,
                                    String.format("Description for %s",
                                            categoryName.name()))));
        }
    }
}
