import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AgencyImpl implements Agency {

    private final Map<String, Invoice> data;
    private Map<LocalDate, List<Invoice>> byDueDate;
    private Set<Invoice> payed;

    public AgencyImpl() {
        this.data = new HashMap<>();
        this.byDueDate = new HashMap<>();
        this.payed = new HashSet<>();
    }

    @Override
    public void create(Invoice invoice) {
        if (this.contains(invoice.getNumber())) {
            throw new IllegalArgumentException();
        }

        this.data.put(invoice.getNumber(), invoice);
        this.byDueDate.putIfAbsent(invoice.getDueDate(), new ArrayList<>());
        this.byDueDate.get(invoice.getDueDate()).add(invoice);
    }

    @Override
    public boolean contains(String number) {
        return this.data.containsKey(number);
    }

    @Override
    public int count() {
        return this.data.size();
    }

    @Override
    public void payInvoice(LocalDate dueDate) {
        Collection<Invoice> invoices = this.byDueDate.get(dueDate);

        if (invoices == null) {
            throw new IllegalArgumentException();
        }

        invoices.forEach(invoice -> invoice.setSubtotal(0));
        payed.addAll(invoices);
    }

    @Override
    public void throwInvoice(String number) {
        Invoice invoice = this.data.get(number);
        if (invoice == null) {
            throw new IllegalArgumentException();
        }

        this.data.remove(number);
        this.payed.remove(invoice);
        this.byDueDate.get(invoice.getDueDate()).remove(invoice);
    }

    @Override
    public void throwPayed() {
//        Map<String, Invoice> result = new HashMap<>();
//
//        for (Map.Entry<String, Invoice> entry : data.entrySet()) {
//            if (entry.getValue().getSubtotal() > 0) {
//                result.put(entry.getKey(), entry.getValue());
//            } else {
//                this.byDueDate.get(entry.getValue().getDueDate()).remove(entry.getValue());
//            }
//        }

        //this.data = result;
        this.payed.forEach(i -> {
            this.data.remove(i.getNumber());
            this.byDueDate.get(i.getDueDate()).remove(i);
        });

        this.payed = new HashSet<>();
    }

    @Override
    public Iterable<Invoice> getAllInvoiceInPeriod(LocalDate startDate, LocalDate endDate) {
        return this.data
                .values()
                .stream()
                .filter(i -> i.getIssueDate().isAfter(startDate) && i.getIssueDate().isBefore(endDate)
                        || i.getIssueDate().isEqual(startDate) || i.getIssueDate().isEqual(endDate))
                .sorted((l, r) -> {
                    int issuedCompare = l.getIssueDate().compareTo(r.getIssueDate());
                    if (issuedCompare == 0) {
                        return l.getDueDate().compareTo(r.getDueDate());
                    }

                    return issuedCompare;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Invoice> searchByNumber(String number) {
        List<Invoice> result = this.data.values()
                .stream()
                .filter(invoice -> invoice.getNumber().contains(number))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    @Override
    public Iterable<Invoice> throwInvoiceInPeriod(LocalDate startDate, LocalDate endDate) {
        Map<LocalDate, List<Invoice>> result = new HashMap<>();
        List<Invoice> inPeriod = new ArrayList<>();

        for (LocalDate dueDate : this.byDueDate.keySet()) {
            if (dueDate.isAfter(startDate) && dueDate.isBefore(endDate)) {
                List<Invoice> toRemove = this.byDueDate.get(dueDate);
                toRemove.forEach(i -> this.data.remove(i.getNumber()));
                inPeriod.addAll(toRemove);
                toRemove.forEach(payed::remove);
            } else {
                result.put(dueDate, this.byDueDate.get(dueDate));
            }
        }

        this.byDueDate = result;

        if (inPeriod.isEmpty()) throw new IllegalArgumentException();

        return inPeriod;
    }

    @Override
    public Iterable<Invoice> getAllFromDepartment(Department department) {
        return this.data.values()
                .stream()
                .filter(invoice -> invoice.getDepartment() == department)
                .sorted((l, r) -> {
                    int subtotalCompare = Double.compare(r.getSubtotal(), l.getSubtotal());
                    if (subtotalCompare == 0) {
                        return l.getIssueDate().compareTo(r.getIssueDate());
                    }
                    return subtotalCompare;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Invoice> getAllByCompany(String companyName) {
        return this.data
                .values()
                .stream()
                .filter(invoice -> invoice.getCompanyName().equals(companyName))
                .sorted((l, r) -> r.getNumber().compareTo(l.getNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public void extendDeadline(LocalDate endDate, int days) {
        LocalDate newDueDate = endDate.plusDays(days);
        List<Invoice> invoices = this.byDueDate.get(endDate);

        if (invoices == null) {
            throw new IllegalArgumentException();
        }

        invoices.forEach(i -> i.setDueDate(newDueDate));

        this.byDueDate.remove(endDate);

        List<Invoice> newDueDateInvoices = this.byDueDate.get(newDueDate);

        if (newDueDateInvoices == null) {
            newDueDateInvoices = new ArrayList<>();
        }


        newDueDateInvoices.addAll(invoices);
        this.byDueDate.put(newDueDate, newDueDateInvoices);
    }
}