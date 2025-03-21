import java.time.LocalDate;

public class AgencyImpl implements Agency {

    public AgencyImpl() {

    }

    @Override
    public void create(Invoice invoice) {

       throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(String number) {
       throw new UnsupportedOperationException();
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void payInvoice(LocalDate dueDate) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void throwInvoice(String number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void throwPayed() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Invoice> getAllInvoiceInPeriod(LocalDate startDate, LocalDate endDate) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Invoice> searchByNumber(String number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Invoice> throwInvoiceInPeriod(LocalDate startDate, LocalDate endDate) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Invoice> getAllFromDepartment(Department department) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Invoice> getAllByCompany(String companyName) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void extendDeadline(LocalDate endDate, int days) {
        throw new UnsupportedOperationException();
    }
}
