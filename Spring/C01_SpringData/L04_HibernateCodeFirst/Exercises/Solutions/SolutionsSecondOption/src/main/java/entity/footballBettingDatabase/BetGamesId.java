package entity.footballBettingDatabase;

import java.io.Serializable;
import java.util.Objects;

public class BetGamesId implements Serializable {
    private Games gameId;
    private Bets betId;

    public BetGamesId(Games gameId, Bets betId) {
        this.gameId = gameId;
        this.betId = betId;
    }

    public Games getGameId() {
        return gameId;
    }

    public void setGameId(Games gameId) {
        this.gameId = gameId;
    }

    public Bets getBetId() {
        return betId;
    }

    public void setBetId(Bets betId) {
        this.betId = betId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BetGamesId)) return false;
        BetGamesId betGameId = (BetGamesId) o;
        return getGameId().equals(betGameId.getGameId()) && getBetId().equals(betGameId.getBetId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameId(), getBetId());
    }
}
