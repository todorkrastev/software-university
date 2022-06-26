package bg.manhattan.shoppinglist.service;

import bg.manhattan.shoppinglist.model.entity.Category;
import bg.manhattan.shoppinglist.model.entity.enums.CategoryNameEnum;

import java.util.Optional;

public interface CategoryService {
    Optional<Category> findByName(CategoryNameEnum category);
}
