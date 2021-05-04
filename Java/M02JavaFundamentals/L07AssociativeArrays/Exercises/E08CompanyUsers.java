    import java.util.*;

    public class E08CompanyUsers {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            Map<String, List<String>> map = new LinkedHashMap<>();

            String command = scanner.nextLine();

            while (!"End".equals(command)) {
                String[] commandParts = command.trim().split("->");
                String company = commandParts[0];
                String employeeId = commandParts[1];

                map.putIfAbsent(company, new ArrayList<>());
                List<String> list = map.get(company);
                if (!list.contains(employeeId)) {
                    list.add(employeeId);
                }

                command = scanner.nextLine();
            }
            map
                    .entrySet()
                    .stream()
                    .sorted((companyFirst, companySecond) -> companyFirst.getKey().compareTo(companySecond.getKey()))
                    .forEach(company -> {
                        System.out.println(company.getKey());
                        company.getValue().forEach(id -> System.out.println(String.format("--%s", id)));
                    });
        }
    }