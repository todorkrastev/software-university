package bg.softuni.java_oop.inheritance.lab.P05_StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private final ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(0, item);
    }

    public String pop() {
        return this.data.remove(0);
    }

    public String peek() {
        return this.data.get(0);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
