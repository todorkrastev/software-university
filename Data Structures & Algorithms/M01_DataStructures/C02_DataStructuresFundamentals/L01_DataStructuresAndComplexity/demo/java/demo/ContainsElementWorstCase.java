package demo;

import java.util.Random;

public class ContainsElementWorstCase {
    public static void main(String[] args) {
        int[] arr = new Random()
                .ints()
                .map(Math::abs)
                .limit(100000000)
                .toArray();

        int element = arr[arr.length - 1] = -1;

        ContainsElementAverage.contains(arr, element);
    }
}
