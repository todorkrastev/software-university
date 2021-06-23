package bg.softuni.java_advanced.iterators_and_comparators.exercises.P04_Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    private final int[] stones;

    public Lake(int[] stones) {
        this.stones = stones;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < stones.length;
            }

            @Override
            public Integer next() {
                int current = stones[index];
                index += 2;
                if (index % 2 == 0 && index >= stones.length) {
                    index = 1;
                }
                return current;
            }
        };
    }
}
