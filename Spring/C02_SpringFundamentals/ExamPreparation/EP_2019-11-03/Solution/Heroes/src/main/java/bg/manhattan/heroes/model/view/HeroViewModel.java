package bg.manhattan.heroes.model.view;

import bg.manhattan.heroes.model.entity.enums.HeroClass;

import java.util.UUID;

public class HeroViewModel {
    private UUID id;
    private String name;
    private String imageUri;

    public UUID getId() {
        return id;
    }

    public HeroViewModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HeroViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUri() {
        return imageUri;
    }

    public HeroViewModel setImageUri(String imageUri) {
        this.imageUri = imageUri;
        return this;
    }
}
