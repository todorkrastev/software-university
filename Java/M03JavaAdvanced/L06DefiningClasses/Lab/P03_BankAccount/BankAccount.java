package bg.softuni.java_advanced.defining_classes.lab.P03_BankAccount;

public class BankAccount {
    private static int idCount = 1;
    private static double interestRate = 0.02;
    private final int id;
    private double balance;

    public BankAccount() {
        this.id = idCount;
        idCount++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}