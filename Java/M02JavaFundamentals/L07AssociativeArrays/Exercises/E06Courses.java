import java.util.*;

public class E06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> map = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] commandParts = command.trim().split(" : ");
            String courseName = commandParts[0];
            String studentName = commandParts[1];

            map.putIfAbsent(courseName, new ArrayList<>());
            map.get(courseName).add(studentName);

            command = scanner.nextLine();
        }
        map
                .entrySet()
                .stream()
                .sorted((firstCourse, secondCourse) -> Integer.compare(secondCourse.getValue().size(), firstCourse.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    entry
                            .getValue()
                            .stream()
                            .sorted((firstStudent, secondStudent) -> firstStudent.compareTo(secondStudent))
                            .forEach(student -> System.out.println(String.format("-- %s", student)));
                });
    }
}