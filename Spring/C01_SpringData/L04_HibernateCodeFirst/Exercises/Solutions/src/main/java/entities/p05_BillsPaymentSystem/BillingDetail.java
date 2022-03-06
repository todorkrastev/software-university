package entities.p05_BillsPaymentSystem;

import entities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetail extends BaseEntity {

    private String number;
    private BankUsers owner;

    public BillingDetail() {
    }

    @Column(name = "number", length = 50, nullable = false, unique = true)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
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
