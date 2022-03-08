package entity.footballBettingDatabase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Games {
    private Long id;
    private Teams homeTeam;
    private Teams awayTeam;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private LocalDateTime dateTime;
    private Double homeTeamWinBetRate;
    private Double awayTeamWinBetRate;
    private Double drawGameBetRate;
    private Rounds roundId;
    private Competitions competitionId;
    private Set<PlayerStatistics> playerStatistics;
    private Set<BetGames> betGames;


    public Games() {

        this.playerStatistics = new HashSet<>();
        this.betGames = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "home_team")
    public Teams getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Teams homeTeam) {
        this.homeTeam = homeTeam;
    }

    @ManyToOne
    @JoinColumn(name = "away_team")
    public Teams getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Teams awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Column(name = "home_team_goals")
    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    @Column(name = "away_team_goals")
    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    @Column(name = "date_time")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Column(name = "home_team_win_bet_rate")
    public Double getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }

    public void setHomeTeamWinBetRate(Double homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    @Column(name = "away_team_win_bet_rate")
    public Double getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(Double awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    @Column(name = "draw_game_bet_rate")
    public Double getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public void setDrawGameBetRate(Double drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    @ManyToOne
    @JoinColumn(name = "round_id")
    public Rounds getRoundId() {
        return roundId;
    }

    public void setRoundId(Rounds roundId) {
        this.roundId = roundId;
    }

    @ManyToOne
    @JoinColumn(name = "competition_id")
    public Competitions getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Competitions competitionId) {
        this.competitionId = competitionId;
    }

    @OneToMany(mappedBy = "gameId")
    public Set<PlayerStatistics> getPlayerStatistics() {
        return playerStatistics;
    }

    public void setPlayerStatistics(Set<PlayerStatistics> playerStatistics) {
        this.playerStatistics = playerStatistics;
    }
@OneToMany(mappedBy = "gameId")
    public Set<BetGames> getBetGames() {
        return betGames;
    }

    public void setBetGames(Set<BetGames> betGames) {
        this.betGames = betGames;
    }
}
