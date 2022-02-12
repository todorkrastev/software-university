import implementations.ArrayList;
import implementations.Stack;
import interfaces.List;

public class Main {
    public static void main(String[] args) {

        Stack<String> el = new Stack<>();

        el.push("c");
        el.push("a");
        el.push("b");

        el.pop();
        el.pop();
        el.pop();

        /*
        List<String> names = new ArrayList<>();

        names.add("one");
        names.add("2");
        names.add("3");
        names.add("4");
        names.add("five");

        names.add(2, "two and a half");

        System.out.println(names.get(0));
        System.out.println(names.get(1));
        System.out.println(names.get(2));
        System.out.println(names.get(3));
        System.out.println(names.get(4));
        System.out.println(names.get(5));
         */
    }
}
