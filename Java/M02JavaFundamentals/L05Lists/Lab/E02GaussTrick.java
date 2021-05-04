import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        findSumNumbers(list);

    }

    private static void findSumNumbers(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                break;
            }
            int firstNum = list.get(i);
            int lastNum = list.get(list.size() - 1);
            list.set(i, firstNum + lastNum);
            list.remove(list.size() - 1);
        }
        for (Integer element : list) {
            System.out.print(element + " ");
        }
    }
}
