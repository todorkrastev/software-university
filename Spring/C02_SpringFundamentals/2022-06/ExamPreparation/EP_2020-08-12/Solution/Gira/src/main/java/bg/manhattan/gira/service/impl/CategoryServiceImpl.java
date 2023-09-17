package bg.manhattan.gira.service.impl;


import bg.manhattan.gira.model.entity.Classification;
import bg.manhattan.gira.model.entity.enums.ClassificationNameEnum;
import bg.manhattan.gira.repository.ClassificationRepository;
import bg.manhattan.gira.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements ClassificationService {

    private final ClassificationRepository repository;

    public CategoryServiceImpl(ClassificationRepository repository) {

        this.repository = repository;
    }

    @Override
    public Optional<Classification> findByName(ClassificationNameEnum classification) {
        return this.repository.findByName(classification);
    }
}
