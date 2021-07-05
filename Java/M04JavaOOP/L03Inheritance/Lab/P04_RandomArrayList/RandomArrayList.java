package bg.softuni.java_oop.inheritance.lab.P04_RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {
    private final Random random;

    public RandomArrayList(){
        this.random = new Random();
    }
    public T getRandomElement() {
        int index = this.random.nextInt(super.size());
        return super.remove(index);
    }
}
