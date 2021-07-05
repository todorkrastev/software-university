package bg.softuni.java_oop.inheritance.lab.P04_RandomArrayList;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList<>();
        IntStream.range(0, 101)
                .forEach(randomArrayList::add);

        System.out.println("Numbers from 0 to 100:");
        randomArrayList
                .forEach(System.out::println);
        System.out.print("Random element: ");
        System.out.println(randomArrayList.getRandomElement());
    }
}
