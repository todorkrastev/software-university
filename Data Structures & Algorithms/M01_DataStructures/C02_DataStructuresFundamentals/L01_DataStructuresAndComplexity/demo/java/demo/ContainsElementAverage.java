package demo;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ContainsElementAverage {
    public static void main(String[] args) {
        int[] arr = new Random()
                .ints()
                .limit(100000000)
                .toArray();

        int element = arr[ThreadLocalRandom.current().nextInt(0, arr.length)];

        contains(arr, element);
    }

    public static boolean contains(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                System.out.println("Element found at index: " + i);
                return true;
            }
        }
        System.out.println("Element not found!");
        return false;
    }
}
