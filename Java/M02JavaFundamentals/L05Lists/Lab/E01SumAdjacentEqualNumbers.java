import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        findEqualNumber(input);

    }

    private static void findEqualNumber(List<Double> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).equals(input.get(i + 1))) {
                input.set(i, input.get(i) + input.get(i + 1));
                input.remove(i + 1);
                i = -1;
            }
        }
        for (Double element : input) {
            System.out.print(new DecimalFormat("0.#").format(element) + " ");
        }
    }
}

