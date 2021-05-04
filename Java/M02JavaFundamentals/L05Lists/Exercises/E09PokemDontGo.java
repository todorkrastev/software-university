import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E09PokemDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int index = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (list.size() != 0) {
            int valueOfIndex = 0;
            if (index < 0) {
                valueOfIndex = list.get(0);
                sum += valueOfIndex;
                list.remove(0);
                if (list.size() == 0) {
                    break;
                }
                list.add(0, list.get(list.size() - 1));
            } else if (list.size() - 1 < index) {
                valueOfIndex = list.get(list.size() - 1);
                sum += valueOfIndex;
                list.remove(list.size() - 1);
                if (list.size() == 0) {
                    break;
                }
                list.add(list.get(0));
            } else {
                valueOfIndex = list.get(index);
                sum += valueOfIndex;
                list.remove(index);
                if (list.size() == 0) {
                    break;
                }
            }
            loop(list, valueOfIndex);
            index = Integer.parseInt(scanner.nextLine());
        }
        System.out.println(sum);
    }

    private static void loop(List<Integer> list, int valueOfIndex) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= valueOfIndex) {
                list.set(i, list.get(i) + valueOfIndex);
            } else if (valueOfIndex < list.get(i)) {
                list.set(i, list.get(i) - valueOfIndex);
            }
        }
    }
}
