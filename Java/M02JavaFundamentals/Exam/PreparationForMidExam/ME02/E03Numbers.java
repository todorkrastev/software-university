import java.util.*;
import java.util.stream.Collectors;

public class E03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> newList = new ArrayList<>();

        int sum = 0;

        for (Integer integer : list) {
            sum += integer;
        }

        double average = (double) sum / list.size();

        for (int i = 0; i < list.size(); i++) {
            if (list.size() == 1) {
                System.out.println("No");
                break;
            } else if (average < list.get(i)) {
                newList.add(list.get(i));
            }
        }
        Collections.sort(newList);
        Collections.reverse(newList);
        int count = 0;
        for (Integer integer : newList) {
            System.out.print(integer + " ");
            count++;
            if (count == 5) {
                break;
            }
        }
    }
}
