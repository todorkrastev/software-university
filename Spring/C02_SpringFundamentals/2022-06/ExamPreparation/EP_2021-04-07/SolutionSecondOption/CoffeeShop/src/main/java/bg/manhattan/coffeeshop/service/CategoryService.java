package bg.manhattan.coffeeshop.service;

import bg.manhattan.coffeeshop.model.entity.Category;
import bg.manhattan.coffeeshop.model.enums.CategoryName;

public interface CategoryService {
    void seed();

    Category getByCategoryName(CategoryName category);
}
