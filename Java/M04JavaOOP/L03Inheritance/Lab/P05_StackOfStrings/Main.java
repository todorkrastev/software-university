package bg.softuni.java_oop.inheritance.lab.P05_StackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();
        stack.push("one");
        stack.push("two");
        stack.push("three");

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
