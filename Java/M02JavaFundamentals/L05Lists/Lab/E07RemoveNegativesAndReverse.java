import java.util.*;
import java.util.stream.Collectors;

public class E07RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            if (Integer.MIN_VALUE <= list.get(i) && list.get(i) < 0) {
                list.remove(list.get(i));
                i = - 1;
            }
        }

        Collections.reverse(list);

        if (list.size() == 0) {
            System.out.println("empty");
        } else {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
        }
    }
}
