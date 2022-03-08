package bg.softuni.springdataintro.services;

import bg.softuni.springdataintro.models.entites.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
