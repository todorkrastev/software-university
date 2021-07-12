package bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite;

import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.commandClasses.*;
import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.interfaces.Command;
import bg.softuni.java_oop.interfaces_and_abstraction.exercises.P06_MilitaryElite.interfaces.Soldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static final List<Soldier> soldiers = new ArrayList<>();
    public static final Map<String, Command> commands = new HashMap<>() {{
        put("P", new PrivateCommand(soldiers));
        put("L", new LieutenantGeneralCommand(soldiers));
        put("E", new EngineerCommand(soldiers));
        put("C", new CommandoCommand(soldiers));
        put("S", new SpyCommand(soldiers));
    }};

    public static void main(String[] args) throws IOException {

       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String input;
        while (!"End".equals(input = reader.readLine())) {
            String command = input.trim().substring(0, 1);
            commands.get(command).execute(Arrays.stream(input.split("\\s+")).skip(1)
                    .collect(Collectors.toList()));
        }
      soldiers
              .forEach(soldier -> System.out.println(soldier.toString()));
    }
}
