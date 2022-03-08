package entity.footballBettingDatabase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "competition_type")
public class CompetitionType {

    private int id;
    private Type type;
    private Set<Competitions> competitions;

    public CompetitionType() {
        this.competitions = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "competitionType")
    public Set<Competitions> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competitions> competitions) {
        this.competitions = competitions;
    }
}
