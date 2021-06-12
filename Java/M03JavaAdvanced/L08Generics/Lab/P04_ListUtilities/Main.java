package P04_ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(-7, 13, 42, 69);

        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMax(integers));

    }
}
