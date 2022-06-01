package bg.softuni.intro.cats.model.dto;

import bg.softuni.intro.cats.repository.OwnerRepository;

import java.util.List;

public class CreateOwnerDto {
    private String ownerName;
    private List<String> catNames;

    public String getOwnerName() {
        return ownerName;
    }

    public CreateOwnerDto setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public List<String> getCatNames() {
        return catNames;
    }

    public CreateOwnerDto setCatNames(List<String> catNames) {
        this.catNames = catNames;
        return this;
    }
}
