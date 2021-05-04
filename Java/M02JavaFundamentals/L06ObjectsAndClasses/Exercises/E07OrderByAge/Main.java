package E07OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Human> people = new ArrayList<>();

        while (!"End".equals(command)) {
            String[] commandParts = command.split("\\s+");
            String name = commandParts[0];
            String ID = commandParts[1];
            int age = Integer.parseInt(commandParts[2]);

            Human human = new Human(name, ID, age);

            people.add(human);

            command = scanner.nextLine();
        }
        people
                .stream()
                .sorted(Comparator.comparing(Human::getAge))
                .forEach(h -> System.out.println(h.getName() + " with ID: " + h.getID() + " is " + h.getAge() + " years old."));
    }
}
