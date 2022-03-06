package entities.p05_BillsPaymentSystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetail{
    private String name;
    private String swift;

    public BankAccount() {
    }

    @Column(name = "bank_name", length = 50, nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String bankName) {
        this.name = bankName;
    }

    @Column(name = "swift", length = 50, nullable = false, unique = true)
    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }
}
