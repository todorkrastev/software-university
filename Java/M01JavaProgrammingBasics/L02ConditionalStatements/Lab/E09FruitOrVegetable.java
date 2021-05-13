package bg.softuni.programming_basics.conditional_statements_advanced.lab;

import java.util.Scanner;

public class E09FruitOrVegetable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        if (text.equals("banana") || text.equals("apple") || text.equals("kiwi") || text.equals("cherry") || text.equals("lemon") || text.equals("grapes")) {
            System.out.println("fruit");
        } else if (text.equals("tomato") || text.equals("cucumber") || text.equals("pepper") || text.equals("carrot")) {
            System.out.println("vegetable");
        } else {
            System.out.println("unknown");
        }
    }
}
