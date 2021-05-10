package bg.softuni.java_advanced.sets_and_maps_advanced.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;

public class E02SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String firstInput;
        while (!"PARTY".equals(firstInput = reader.readLine())) {
            fillGuestList(vip, regular, firstInput);
        }
        String secondInput;
        while (!"END".equals(secondInput = reader.readLine())) {
            vip.remove(secondInput);
            regular.remove(secondInput);
        }
        System.out.println(vip.size() + regular.size());
        vip
                .forEach(System.out::println);
        regular
                .forEach(System.out::println);
    }

    private static void fillGuestList(Set<String> vip, Set<String> regular, String firstInput) {
        char[] ch = firstInput.toCharArray();
        if (Character.isDigit(ch[0])) {
            vip.add(firstInput);
        } else if (Character.isAlphabetic(ch[0])) {
            regular.add(firstInput);
        }
    }
}
