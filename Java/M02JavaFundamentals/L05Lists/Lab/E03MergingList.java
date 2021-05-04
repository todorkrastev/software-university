import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03MergingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        findResultList(firstList, secondList);
    }

    private static void findResultList(List<Integer> firstList, List<Integer> secondList) {
        int minLen = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < minLen; i++) {
            System.out.print(firstList.get(i) + " " + secondList.get(i) + " ");
        }
        printAfterIndex(firstList, minLen);
        printAfterIndex(secondList, minLen);
    }

    private static void printAfterIndex(List<Integer> list, int startIndex) {
        for (int i = startIndex; i < list.size() ; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}


