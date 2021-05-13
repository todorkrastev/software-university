package bg.softuni.programming_basics.nested_loops.lab;

public class E01Clock {
    public static void main(String[] args) {

        for (int i = 0; i <= 23; i++) {
            for (int a = 0; a <= 59; a++) {
                System.out.printf("%d:%d%n", i, a);
            }
        }
    }
}
