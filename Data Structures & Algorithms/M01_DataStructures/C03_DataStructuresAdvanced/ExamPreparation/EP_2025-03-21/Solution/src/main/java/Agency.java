import java.time.LocalDate;

public interface Agency {

    void create(Invoice invoice);

    boolean contains(String number);

    int count();

    void payInvoice(LocalDate dueDate);

    void throwInvoice(String number);

    void throwPayed();

    Iterable<Invoice> getAllInvoiceInPeriod(LocalDate startDate, LocalDate endDate);

    Iterable<Invoice> searchByNumber(String number);

    Iterable<Invoice> throwInvoiceInPeriod(LocalDate startDate, LocalDate endDate);

    Iterable<Invoice> getAllFromDepartment(Department department);

    Iterable<Invoice> getAllByCompany(String companyName);

    void extendDeadline(LocalDate endDate, int days);

}
