import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
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

            if (isStudentExisting(students, firstName, lastName)) {
                Student student = getStudent(students, firstName, lastName);

                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHometown(hometown);
            } else {
                Student student = new Student();

                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHometown(hometown);

                students.add(student);
            }

            command = scanner.nextLine();
        }
        String cityName = scanner.nextLine();

        for (Student student : students) {
            if (student.getHometown().equals(cityName)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        Student existingStudent = null;

        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }

    private static boolean isStudentExisting(List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
}
