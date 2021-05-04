import java.util.*;

public class E02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> synonyms = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String key = scanner.nextLine();
            String synonym = scanner.nextLine();

            synonyms.putIfAbsent(key, new ArrayList<>());
            List<String> stringList = synonyms.get(key);
            stringList.add(synonym);

            synonyms.put(key, stringList);
        }
        for (Map.Entry<String, List<String>> entry : synonyms.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(),
                    entry.getValue()
                            .toString()
                            .replaceAll("[\\[\\]]", ""));
        }
    }
}