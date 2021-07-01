package bg.softuni.java_oop.working_with_abstraction.exercises.P03_CardsWithPower;

public class Card {
    private final CardRank rank;
    private final CardSuit suit;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getPowerCard() {
        return rank.getPower() + suit.getPower();
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d%n", this.getRank(), this.getSuit(), this.getPowerCard()).trim();
    }
}
