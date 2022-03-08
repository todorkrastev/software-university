package entity.footballBettingDatabase;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Players extends BaseNameEntity {
    private Short squadNumber;
    private Teams team;
    private Position position;
    private boolean isCurrentlyInjured;
    private Set<PlayerStatistics>playerStatistics;

    public Players() {
        this.playerStatistics = new HashSet<>();
    }

    @Column(name = "squad_number", nullable = false)
    public Short getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(Short squadNumber) {
        this.squadNumber = squadNumber;
    }
@ManyToOne
@JoinColumn(name = "team_id")
    public Teams getTeam() {
        return team;
    }

    public void setTeam(Teams team) {
        this.team = team;
    }
@ManyToOne
@JoinColumn(name = "position_id")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
@Column(name = "is_injured")
    public boolean isCurrentlyInjured() {
        return isCurrentlyInjured;
    }

    public void setCurrentlyInjured(boolean currentlyInjured) {
        isCurrentlyInjured = currentlyInjured;
    }
@OneToMany(mappedBy = "playerId")
    public Set<PlayerStatistics> getPlayerStatistics() {
        return playerStatistics;
    }

    public void setPlayerStatistics(Set<PlayerStatistics> playerStatistics) {
        this.playerStatistics = playerStatistics;
    }
}
