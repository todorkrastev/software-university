import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> occurrences = new TreeMap<>();

        for (double v : array) {
            double currentNum = Double.parseDouble(String.valueOf(v));

            if (occurrences.containsKey(currentNum)) {
                Integer currCount = occurrences.get(currentNum);

                occurrences.put(currentNum, currCount + 1);
            } else {
                occurrences.put(currentNum, 1);
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%s -> %d%n",
                    decimalFormat.format(entry.getKey()), entry.getValue());
        }
    }
}