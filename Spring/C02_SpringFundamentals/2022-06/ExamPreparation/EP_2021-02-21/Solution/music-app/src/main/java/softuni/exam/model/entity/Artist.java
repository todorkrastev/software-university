package softuni.exam.model.entity;

import softuni.exam.model.entity.enums.ArtistNameEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity {

    private ArtistNameEnum name;
    private String careerInformation;

    @NotNull
    @Enumerated(EnumType.STRING)
    public ArtistNameEnum getName() {
        return name;
    }

    public void setName(ArtistNameEnum name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
