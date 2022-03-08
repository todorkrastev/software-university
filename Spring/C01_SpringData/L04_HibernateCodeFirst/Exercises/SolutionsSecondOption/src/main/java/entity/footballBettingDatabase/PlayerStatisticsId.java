package entity.footballBettingDatabase;

import java.io.Serializable;
import java.util.Objects;

public class PlayerStatisticsId implements Serializable {
    private Games gameId;
    private Players playerId;

    public PlayerStatisticsId() {
    }

    public PlayerStatisticsId(Games gameId, Players playerId) {
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public Games getGameId() {
        return gameId;
    }

    public void setGameId(Games gameId) {
        this.gameId = gameId;
    }

    public Players getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Players playerId) {
        this.playerId = playerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerStatisticsId)) return false;
        PlayerStatisticsId that = (PlayerStatisticsId) o;
        return gameId.equals(that.gameId) && playerId.equals(that.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, playerId);
    }
}
