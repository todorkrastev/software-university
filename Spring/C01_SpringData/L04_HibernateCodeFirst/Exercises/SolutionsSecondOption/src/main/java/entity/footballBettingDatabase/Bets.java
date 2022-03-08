package entity.footballBettingDatabase;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bets")
public class Bets {
    private Long id;
    private BigDecimal betMoney;
    private LocalDateTime dateAndTimeOfBet;
    private Users user;
    private Set<BetGames> betGames;

    public Bets() {
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

    @Column(name = "bet_money", nullable = false)
    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    @Column(name = "date_time")
    public LocalDateTime getDateAndTimeOfBet() {
        return dateAndTimeOfBet;
    }

    public void setDateAndTimeOfBet(LocalDateTime dateAndTimeOfBet) {
        this.dateAndTimeOfBet = dateAndTimeOfBet;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
@OneToMany(mappedBy = "betId")
    public Set<BetGames> getBetGames() {
        return betGames;
    }

    public void setBetGames(Set<BetGames> betGames) {
        this.betGames = betGames;
    }
}
