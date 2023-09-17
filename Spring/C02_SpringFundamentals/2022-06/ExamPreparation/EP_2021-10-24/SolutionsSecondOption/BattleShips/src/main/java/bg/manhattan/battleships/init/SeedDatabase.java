package bg.manhattan.battleships.init;

import bg.manhattan.battleships.model.entity.Category;
import bg.manhattan.battleships.model.entity.enums.CategoryNameEnum;
import bg.manhattan.battleships.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeedDatabase implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public SeedDatabase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        if (this.categoryRepository.findAll().isEmpty()) {
            List<Category> categories = Arrays.stream(CategoryNameEnum.values())
                    .map(categoryName -> new Category().setName(categoryName))
                    .collect(Collectors.toList());
            this.categoryRepository.saveAll(categories);
        }
    }
}
