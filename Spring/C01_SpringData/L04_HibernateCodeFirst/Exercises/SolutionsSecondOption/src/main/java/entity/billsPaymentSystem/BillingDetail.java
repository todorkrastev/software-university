package entity.billsPaymentSystem;

import entity.footballBettingDatabase.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetail extends BaseEntity {
    private Long number;
    private BankUsers owner;

    public BillingDetail() {
    }


    @Column(name = "number", nullable = false, unique = true
    )
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @ManyToOne
    public BankUsers getOwner() {
        return owner;
    }

    public void setOwner(BankUsers owner) {
        this.owner = owner;
    }
}