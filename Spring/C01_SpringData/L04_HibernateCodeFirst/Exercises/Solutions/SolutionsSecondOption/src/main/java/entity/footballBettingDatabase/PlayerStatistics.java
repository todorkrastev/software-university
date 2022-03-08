package entity.footballBettingDatabase;

import javax.persistence.*;

@Entity
@Table(name = "player_statistics")
@IdClass(PlayerStatisticsId.class)
public class PlayerStatistics {

    private Games gameId;

    private Players playerId;

    private int scoredGoals;
    private int playerAssists;
    private int playedMinutes;

    public PlayerStatistics() {
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id")
    public Games getGameId() {
        return gameId;
    }

    public void setGameId(Games gameId) {
        this.gameId = gameId;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id")
    public Players getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Players playerId) {
        this.playerId = playerId;
    }

    @Column(name = "scored_goals")
    public int getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(int scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Column(name = "player_assists")
    public int getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(int playerAssists) {
        this.playerAssists = playerAssists;
    }

    @Column(name = "played_minutes")
    public int getPlayedMinutes() {
        return playedMinutes;
    }

    public void setPlayedMinutes(int playedMinutes) {
        this.playedMinutes = playedMinutes;
    }
}
