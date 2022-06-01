package bg.softuni.intro.cats.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ownerName;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<CatEntity> casts;

    public OwnerEntity() {
        this.casts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public OwnerEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public OwnerEntity setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public List<CatEntity> getCasts() {
        return casts;
    }

    public OwnerEntity setCasts(List<CatEntity> casts) {
        this.casts = casts;
        return this;
    }

    public void addCat(CatEntity cat) {
        this.casts.add(cat);
    }
}
