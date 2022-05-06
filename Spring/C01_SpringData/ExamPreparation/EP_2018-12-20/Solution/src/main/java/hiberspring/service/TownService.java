package hiberspring.service;

import hiberspring.domain.entities.Town;

import java.io.IOException;
import java.util.Optional;

public interface TownService {

    Boolean townsAreImported();

    String readTownsJsonFile() throws IOException;

    String importTowns(String townsFileContent) throws IOException;

    Optional<Town> getTownByName(String town);
}
