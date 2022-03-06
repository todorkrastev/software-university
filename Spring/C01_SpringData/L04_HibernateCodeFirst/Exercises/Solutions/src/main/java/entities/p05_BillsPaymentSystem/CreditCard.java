package entities.p05_BillsPaymentSystem;

import entities.p05_BillsPaymentSystem.enums.CardType;

import javax.persistence.*;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {
    private CardType type;
    private Integer expirationMonth;
    private Integer expirationYear;

    public CreditCard() {
    }

    @Enumerated(EnumType.STRING)
    public CardType getType() {
        return type;
    }

    public void setType(CardType cardType) {
        this.type = cardType;
    }

    @Column(name = "expiration_month")
    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Column(name = "expiration_year")
    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }
}
