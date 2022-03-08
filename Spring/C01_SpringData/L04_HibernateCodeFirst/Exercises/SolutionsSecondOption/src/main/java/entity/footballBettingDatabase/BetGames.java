package entity.footballBettingDatabase;

import javax.persistence.*;

@Entity
@IdClass(BetGamesId.class)
@Table(name = "bet_games")
public class BetGames {
    private Games gameId;
    private Bets betId;
    private ResultPrediction resultPrediction;

    public BetGames() {
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
@JoinColumn(name = "bet_id")
    public Bets getBetId() {
        return betId;
    }

    public void setBetId(Bets betId) {
        this.betId = betId;
    }
@OneToOne
@JoinColumn(name = "result_prediction")
    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}
