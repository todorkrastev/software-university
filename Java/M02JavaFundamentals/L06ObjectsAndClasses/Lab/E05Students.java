import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E05Students {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] commandParts = command.split("\\s+");
            String firstName = commandParts[0];
            String lastName = commandParts[1];
            int age = Integer.parseInt(commandParts[2]);
            String hometown = commandParts[3];

            Student student = new Student();

            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setAge(age);
            student.setHometown(hometown);

            students.add(student);

            command = scanner.nextLine();
        }
        String cityName = scanner.nextLine();

        for (Student student : students) {
            if (student.getHometown().equals(cityName)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
