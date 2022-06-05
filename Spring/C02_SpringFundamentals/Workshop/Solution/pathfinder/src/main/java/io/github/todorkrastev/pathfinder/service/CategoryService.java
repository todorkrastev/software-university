package io.github.todorkrastev.pathfinder.service;

import io.github.todorkrastev.pathfinder.model.entity.Category;
import io.github.todorkrastev.pathfinder.model.entity.enums.CategoryName;

public interface CategoryService {
    Category findCategoryByName(CategoryName name);
}
