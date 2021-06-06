package bg.softuni.java_advanced.defining_classes.exercises.P02_CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;
    private static String defaultEmail;
    private static int defaultAge;

    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, defaultEmail, defaultAge);
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, defaultAge);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, defaultEmail, age);
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public static void setDefaultEmail(String defaultEmail) {
        Employee.defaultEmail = defaultEmail;
    }

    public static void setDefaultAge(int defaultAge) {
        Employee.defaultAge = defaultAge;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
