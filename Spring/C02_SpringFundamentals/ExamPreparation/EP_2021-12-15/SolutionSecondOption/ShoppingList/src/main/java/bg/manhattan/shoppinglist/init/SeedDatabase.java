package bg.manhattan.shoppinglist.init;

import bg.manhattan.shoppinglist.model.entity.Category;
import bg.manhattan.shoppinglist.model.entity.enums.CategoryNameEnum;
import bg.manhattan.shoppinglist.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SeedDatabase implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public SeedDatabase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.findAll().isEmpty()) {
            Arrays.stream(CategoryNameEnum.values())
                    .map(categoryName -> new Category().setName(categoryName))
                    .forEach(category -> this.categoryRepository.save(category));
        }
    }
}
