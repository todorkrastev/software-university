import java.util.*;

public class E07StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(grade);
        }
        map
                .entrySet()
                .stream()
                .filter(student -> student.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50)
                .sorted((firstStudent, secondStudent) -> {
                    double first = firstStudent.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double second = secondStudent.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(second, first);
                })
                .forEach(student -> System.out.println(String.format("%s -> %.2f",
                        student.getKey(),
                        student.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble())));
    }
}