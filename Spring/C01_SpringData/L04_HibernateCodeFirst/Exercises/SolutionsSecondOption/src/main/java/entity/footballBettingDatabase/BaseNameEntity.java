package entity.footballBettingDatabase;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseNameEntity {
    private Long id;
    private String name;

    public BaseNameEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
