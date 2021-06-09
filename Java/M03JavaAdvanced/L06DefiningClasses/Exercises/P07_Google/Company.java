package bg.softuni.java_advanced.defining_classes.exercises.P07_Google;

public class Company {
    private final String companyName;
    private final String department;
    private final double salary;

    public Company(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", companyName, department, salary);
    }
}
