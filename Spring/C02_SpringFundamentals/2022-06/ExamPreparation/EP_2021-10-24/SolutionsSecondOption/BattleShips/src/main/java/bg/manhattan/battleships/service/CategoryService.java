package bg.manhattan.battleships.service;

import bg.manhattan.battleships.model.entity.Category;
import bg.manhattan.battleships.model.entity.enums.CategoryNameEnum;

import java.util.Optional;

public interface CategoryService {
    Optional<Category> findByName(CategoryNameEnum category);
}
