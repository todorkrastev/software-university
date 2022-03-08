package entity.billsPaymentSystem;

import entity.footballBettingDatabase.Months;

import javax.persistence.*;

@Entity
@Table(name = "credit_card ")
public class CreditCard extends BillingDetail {
    private CardType cardType;
    private Months expirationMonth;
    private Short expirationYear;

    public CreditCard() {
    }

    @Column(name = "card_type")
    @Enumerated(EnumType.STRING)
    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Column(name = "get_expiration_month")
    @Enumerated(EnumType.STRING)
    public Months getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Months expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Column(name = "get_expiration_year")
    public Short getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Short expirationYear) {
        this.expirationYear = expirationYear;
    }
}
