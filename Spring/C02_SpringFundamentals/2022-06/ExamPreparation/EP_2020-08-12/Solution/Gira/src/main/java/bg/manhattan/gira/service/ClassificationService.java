package bg.manhattan.gira.service;


import bg.manhattan.gira.model.entity.Classification;
import bg.manhattan.gira.model.entity.enums.ClassificationNameEnum;

import java.util.Optional;

public interface ClassificationService {
    Optional<Classification> findByName(ClassificationNameEnum classification);

}
