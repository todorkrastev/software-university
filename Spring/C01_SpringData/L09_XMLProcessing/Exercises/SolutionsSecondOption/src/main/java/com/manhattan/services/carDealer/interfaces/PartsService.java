package com.manhattan.services.carDealer.interfaces;

import com.manhattan.models.carDealer.entities.Part;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public interface PartsService {
    void saveAll(Iterable<Part> parts);
    Set<Part> getRandomParts();

    boolean hasNoRecords();
}
