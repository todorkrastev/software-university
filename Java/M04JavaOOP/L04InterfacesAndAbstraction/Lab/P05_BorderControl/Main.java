package bg.softuni.java_oop.interfaces_and_abstraction.lab.border;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        List<Identifiable> ids = new ArrayList<>();

        String command;
        while (!"end".equalsIgnoreCase(command = reader.readLine())) {
            String[] info = command.trim().split("\\s+");

            if (info.length == 3) {
                String name = info[0];
                int age = Integer.parseInt(info[1]);
                String id = info[2];
                Citizen citizen = new Citizen(name, age, id);
                ids.add(citizen);
            } else if (info.length == 2) {
                String model = info[0];
                String id = info[1];
                Robot robot = new Robot(model, id);
                ids.add(robot);
            }
        }
        String lastDigitsFakeIds = reader.readLine();

        ids
                .stream()
                .filter(id -> id.getId().endsWith(lastDigitsFakeIds))
                .forEach(id -> System.out.println(id.getId()));
    }
}
