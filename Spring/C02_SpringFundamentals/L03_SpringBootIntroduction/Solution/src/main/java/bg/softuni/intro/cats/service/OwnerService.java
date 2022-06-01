package bg.softuni.intro.cats.service;

import bg.softuni.intro.cats.model.dto.CreateOwnerDto;

public interface OwnerService {
    void createOwner(CreateOwnerDto createOwnerDto);
}
