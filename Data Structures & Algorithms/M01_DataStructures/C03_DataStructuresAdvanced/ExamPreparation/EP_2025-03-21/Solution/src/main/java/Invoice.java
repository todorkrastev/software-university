import java.time.LocalDate;

public class Invoice {

    private String number;
    private String companyName;
    private double subtotal;
    private Department department;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public Invoice(String number, String companyName, double subtotal, Department department, LocalDate issueDate, LocalDate dueDate) {
        this.number = number;
        this.companyName = companyName;
        this.subtotal = subtotal;
        this.department = department;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
