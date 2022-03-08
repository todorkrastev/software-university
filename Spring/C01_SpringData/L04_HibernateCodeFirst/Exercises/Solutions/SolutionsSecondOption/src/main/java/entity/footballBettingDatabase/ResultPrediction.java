package entity.footballBettingDatabase;

import javax.persistence.*;

@Entity
@Table(name = "result_prediction")
public class ResultPrediction {
    private Long id;
    private Prediction prediction;
    private BetGames betGames;

    public ResultPrediction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "prediction")
    @Enumerated(EnumType.STRING)
    public Prediction getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction prediction) {
        this.prediction = prediction;
    }

    @OneToOne(mappedBy = "resultPrediction")
    public BetGames getBetGames() {
        return betGames;
    }

    public void setBetGames(BetGames betGames) {
        this.betGames = betGames;
    }
}
