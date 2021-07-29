public interface Transaction {
    int getId();

    TransactionStatus getStatus();

    void setStatus(TransactionStatus newStatus);

    double getAmount();

    String getFrom();

    String getTo();
}
