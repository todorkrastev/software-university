package bg.manhattan.gira.init;


import bg.manhattan.gira.model.entity.Classification;
import bg.manhattan.gira.model.entity.enums.ClassificationNameEnum;
import bg.manhattan.gira.repository.ClassificationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeedDatabase implements CommandLineRunner {
    private final ClassificationRepository classificationRepository;

    public SeedDatabase(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }


    @Override
    public void run(String... args) {
        if (this.classificationRepository.findAll().isEmpty()) {
            List<Classification> categories = Arrays.stream(ClassificationNameEnum.values())
                    .map(categoryName -> new Classification().setName(categoryName))
                    .collect(Collectors.toList());
            this.classificationRepository.saveAll(categories);
        }
    }
}
