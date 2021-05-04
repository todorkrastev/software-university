import java.util.*;

public class E07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\|");
        List<String> list = new ArrayList<>();

        for (int i = array.length - 1; i >= 0; i--) {
            String[] arrayParts = array[i].split("\\s+");
            for (String arrayPart : arrayParts) {
                if (!"".equals(arrayPart)) {
                    list.add(arrayPart);
                }
            }
        }
        System.out.println(String.join(" ", list));
    }
}
