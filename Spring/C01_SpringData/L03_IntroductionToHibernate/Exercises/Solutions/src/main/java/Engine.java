import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private final BufferedReader reader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        printLineSeparator();
        System.out.println("""
                Hello there! Welcome to my code!
                Please, select exercise number:""");
        try {
            int exerciseNum = Integer.parseInt(reader.readLine());
            switch (exerciseNum) {
                case 2 -> {
                    printWelcomeMessage(" 2 -> Change Casing");
                    p02_ChangeCasing();
                }
                case 3 -> {
                    printWelcomeMessage(" 3 -> Contains Employee");
                    p03_ContainsEmployee();
                }
                case 4 -> {
                    printWelcomeMessage(" 4 -> Employees with Salary Over 50 000");
                    p04_EmployeesWithSalaryOver50000();
                }
                case 5 -> {
                    printWelcomeMessage(" 5 -> Employees from Department");
                    p05_EmployeesFromDepartment();
                }
                case 6 -> {
                    printWelcomeMessage(" 6 -> Adding a New Address and Updating Employee");
                    p06_AddingNewAddressAndUpdatingEmployee();
                }
                case 7 -> {
                    printWelcomeMessage(" 7 -> Addresses with Employee Count");
                    p07_AddressesWithEmployeeCount();
                }
                case 8 -> {
                    printWelcomeMessage(" 8 -> Get Employee with Project");
                    p08_GetEmployeeWithProject();
                }
                case 9 -> {
                    printWelcomeMessage(" 9 -> Find Latest 10 Projects");
                    p09_FindLatest10Projects();
                }
                case 10 -> {
                    printWelcomeMessage(" 10 -> Increase Salaries");
                    p10_IncreaseSalaries();
                }
                case 11 -> {
                    printWelcomeMessage(" 11 -> Find Employees by First Name");
                    p11_FindEmployeesByFirstName();
                }
                case 12 -> {
                    printWelcomeMessage(" 12 -> Employees Maximum Salaries");
                    p12_EmployeesMaximumSalaries();
                }
                case 13 -> {
                    printWelcomeMessage(" 13 -> Remove Towns");
                    p13_RemoveTowns();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    private void p13_RemoveTowns() throws IOException {
        System.out.println("Please, enter the name of city");
        String townName = reader.readLine();

        Town town = entityManager
                .createQuery("SELECT t FROM Town t WHERE t.name = :town_name",
                        Town.class)
                .setParameter("town_name", townName)
                .getSingleResult();


        int affectedRows = removeAddressesByTownId(town.getId());

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();

        printOutputMessage(13);
        System.out.printf("%d %s in %s is deleted%n", affectedRows, affectedRows <= 1 ? "address" : "addresses", townName);
        printLineSeparator();
    }

    private int removeAddressesByTownId(Integer id) {
        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a " +
                        "WHERE a.town.id = :p_id", Address.class)
                .setParameter("p_id", id)
                .getResultList();

        entityManager.getTransaction().begin();
        addresses.forEach(entityManager::remove);
        entityManager.getTransaction().commit();

        return addresses.size();
    }

    private void p12_EmployeesMaximumSalaries() {
        printOutputMessage(12);

        List<Object[]> rows = entityManager.createNativeQuery("SELECT d.name, MAX(e.salary) AS m_salary FROM departments d " +
                        "JOIN employees e on d.department_id = e.department_id " +
                        "GROUP BY d.name " +
                        "HAVING m_salary NOT BETWEEN 30000 AND 70000;")
                .getResultList();

        rows.forEach(r -> System.out.printf("%s %.2f%n", r[0], r[1]));
        printLineSeparator();
    }

    private void p11_FindEmployeesByFirstName() throws IOException {
        System.out.println("""
                Are you looking for a specific first name of an employee?
                Please, enter the desired pattern""");

        String pattern = reader.readLine();
        String wildcard = pattern + "%";


        printOutputMessage(11);

        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.firstName LIKE :w", Employee.class)
                .setParameter("w", wildcard)
                .getResultList()
                .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getJobTitle(),
                        e.getSalary()));

        printLineSeparator();
    }

    private void p10_IncreaseSalaries() {
        entityManager.getTransaction().begin();
        int affectedRows = entityManager.createQuery("UPDATE Employee e " +
                        "SET e.salary = e.salary * 1.2 " +
                        "WHERE e.department.id IN :ids")
                .setParameter("ids", Set.of(1, 2, 4, 11))
                .executeUpdate();

        entityManager.getTransaction().commit();

        printOutputMessage(10);
        System.out.println("The transaction was successfully completed. Number of increased salaries: " + affectedRows);
        printLineSeparator();
    }

    private void p09_FindLatest10Projects() {
        printOutputMessage(9);

        entityManager.createQuery("SELECT p FROM Project p " +
                        "ORDER BY p.startDate DESC", Project.class)
                .getResultList()
                .stream()
                .limit(10)
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("Project name: %s%n" +
                                "\t Project Description: %s%n" +
                                "\t Project Start Date:%s%n" +
                                "\t Project End Date:%s%n",
                        p.getName(),
                        p.getDescription(),
                        p.getStartDate().toString().replaceFirst("T", " "),
                        p.getEndDate() != null ? p.getEndDate().toString().replaceFirst("T", " ") : null));

        printLineSeparator();
    }

    private void p08_GetEmployeeWithProject() throws IOException {
        System.out.println("Please, enter employee's id");
        int id = Integer.parseInt(reader.readLine());

        printOutputMessage(8);

        Employee employee = entityManager.find(Employee.class, id);

        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("\t%s%n", p.getName()));

        printLineSeparator();
    }

    private void p07_AddressesWithEmployeeCount() {
        printOutputMessage(7);
        entityManager.createQuery("SELECT a FROM Address a " +
                        "ORDER BY a.employees.size DESC", Address.class)
                .getResultList()
                .stream()
                .limit(10)
                .forEach(address -> System.out.printf("%s , %s - %d employees%n",
                        address.getText(),
                        address.getTown() == null
                                ? "Unknown" : address.getTown().getName(),
                        address.getEmployees().size()));
        printLineSeparator();
    }

    private void p06_AddingNewAddressAndUpdatingEmployee() throws IOException {
        System.out.println("Please, enter last name of an employee");
        String lastName = reader.readLine().trim();

        Employee employee = entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.lastName = :last_name", Employee.class)
                .setParameter("last_name", lastName)
                .getSingleResult();

        Address address = creteAddress("Vitoshka 15");

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
        printOutputMessage(6);
        System.out.printf("The address of %s %s is successfully changed to %s%n", employee.getFirstName(), employee.getLastName(), employee.getAddress().getText());
        printLineSeparator();
    }

    private void p05_EmployeesFromDepartment() {
        printOutputMessage(5);

        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = :department " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("department", "Research and Development")
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                        e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));

        printLineSeparator();
    }

    private void p04_EmployeesWithSalaryOver50000() throws IOException {
        printOutputMessage(4);

        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.salary > :salary", Employee.class)
                .setParameter("salary", BigDecimal.valueOf(50000L))
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);

        printLineSeparator();
    }

    private void p03_ContainsEmployee() throws IOException {
        System.out.println("Please, enter first and last name of an employee");
        String[] fullName = reader.readLine().trim().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Long singleResult =
                entityManager.createQuery("SELECT COUNT(e) " +
                                "FROM Employee e " +
                                "WHERE e.firstName = :first_name AND e.lastName = :last_name", Long.class)
                        .setParameter("first_name", firstName)
                        .setParameter("last_name", lastName)
                        .getSingleResult();

        printOutputMessage(3);
        String output = singleResult == 1 ? "Yes" : "No";
        System.out.println(output);
        printLineSeparator();
    }

    private void p02_ChangeCasing() {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Town t " +
                "SET t.name = UPPER(t.name) " +
                "WHERE LENGTH(t.name) <= 5");

        int affectedRows = query.executeUpdate();
        printOutputMessage(2);
        System.out.println("Total count of all names changed to upper case: " + affectedRows);
        printLineSeparator();

        entityManager.getTransaction().commit();
    }

    private Address creteAddress(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;
    }

    private void printOutputMessage(int exercise) {
        printLineSeparator();
        System.out.printf("Output exercise %d: %n", exercise);
    }

    private void printWelcomeMessage(String exerciseName) {
        printLineSeparator();
        System.out.println("You selected exercise " + exerciseName);
    }

    private void printLineSeparator() {
        System.out.println("*".repeat(100));
    }

}
