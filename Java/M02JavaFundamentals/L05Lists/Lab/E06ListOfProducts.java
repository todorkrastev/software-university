import java.util.*;

public class E06ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLine());
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int currNum = i + 1;
            System.out.printf("%d.%s%n", currNum, list.get(i));
        }
    }
}


