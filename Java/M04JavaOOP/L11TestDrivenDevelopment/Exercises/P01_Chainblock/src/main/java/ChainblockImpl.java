import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactionsByIds;

    public ChainblockImpl() {
        this.transactionsByIds = new HashMap<>();
    }

    public int getCount() {
        return this.transactionsByIds.size();
    }

    public void add(Transaction transaction) {
        if (!contains(transaction)) {
            this.transactionsByIds.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactionsByIds.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        validateContainsTransactionId(id);
        this.transactionsByIds.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        validateContainsTransactionId(id);
        this.transactionsByIds.remove(id);
    }

    private void validateContainsTransactionId(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }
    }

    public Transaction getById(int id) {
        validateContainsTransactionId(id);
        return this.transactionsByIds.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = new ArrayList<>();

        for (Transaction transaction : transactionsByIds.values()) {
            if (transaction.getStatus() == status) {
                transactionList.add(transaction);
            }
        }

        if (transactionList.size() == 0) {
            throw new IllegalArgumentException();
        }

        transactionList.sort(Comparator.comparing(Transaction::getAmount).reversed());

        return transactionList;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        return getTransactionByStatusOrderByAmountAsList(status).stream()
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return getTransactionByStatusOrderByAmountAsList(status).stream()
                .map(Transaction::getTo)
                .collect(Collectors.toList());
    }

    private List<Transaction> getTransactionByStatusOrderByAmountAsList(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();

        getByTransactionStatus(status).forEach(transactions::add);
        return transactions;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactionsByIds.values()
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactions = new ArrayList<>();

        for (Transaction transaction : transactionsByIds.values()) {
            if (transaction.getFrom().equals(sender)) {
                transactions.add(transaction);
            }
        }

        if (transactions.size() == 0) {
            throw new IllegalArgumentException();
        }

        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactions = new ArrayList<>();

        for (Transaction transaction : transactionsByIds.values()) {
            if (transaction.getTo().equals(receiver)) {
                transactions.add(transaction);
            }
        }

        if (transactions.size() == 0) {
            throw new IllegalArgumentException();
        }

        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> transactions = getTransactionByStatusOrderByAmountAsList(status);
        return transactions.stream()
                .filter(t -> t.getAmount() <= amount)
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
