package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Employee employee) {
        if (this.employees.size() < capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return this.employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append("Employees working at Bakery ").append(this.getName()).append(":");
        this.employees
                .forEach(employee -> output.append(System.lineSeparator()).append(employee));
        return output.toString();
    }
}
