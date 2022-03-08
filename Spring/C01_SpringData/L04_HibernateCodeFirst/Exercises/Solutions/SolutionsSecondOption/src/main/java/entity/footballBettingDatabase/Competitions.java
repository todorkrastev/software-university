package entity.footballBettingDatabase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Competitions extends BaseNameEntity{
    private CompetitionType competitionType;
    private Set<Games> games;

    public Competitions() {
        this.games = new HashSet<>();
    }
@ManyToOne
@JoinColumn(name = "competition_type")
    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }

    @OneToMany(mappedBy = "competitionId")
    public Set<Games> getGames() {
        return games;
    }

    public void setGames(Set<Games> games) {
        this.games = games;
    }
}
