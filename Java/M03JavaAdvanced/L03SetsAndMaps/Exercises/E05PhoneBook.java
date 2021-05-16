package bg.softuni.java_advanced.sets_and_maps_advanced.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class E05PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, String> map = new HashMap<>();

        String input;
        while (!"search".equals(input = reader.readLine())) {
            String[] split = input.trim().split("-");
            String name = split[0];
            String phoneNum = split[1];

            map.put(name, phoneNum);
        }

        String searchContact;
        while (!"stop".equals(searchContact = reader.readLine())) {
            if (map.containsKey(searchContact)) {
                System.out.println(searchContact + " -> " + map.get(searchContact));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchContact);
            }
        }
    }
}
