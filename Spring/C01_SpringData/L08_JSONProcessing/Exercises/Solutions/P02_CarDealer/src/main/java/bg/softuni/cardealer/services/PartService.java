package bg.softuni.cardealer.services;

import bg.softuni.cardealer.models.entities.Part;

import java.io.IOException;
import java.util.Set;

public interface PartService {
    void seedParts() throws IOException;

    Set<Part> getRandomParts();
}
