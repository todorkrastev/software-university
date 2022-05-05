package softuni.exam.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="team")
public class Team extends BaseEntity {
    /**
     * A string (required) between 3 and 20 characters.
     */
    @Column(nullable = false, length = 20)
    private String name;

    /**
     * A Picture entity (required).
     */
    @ManyToOne
    private Picture picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
