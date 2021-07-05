package bg.softuni.java_oop.encapsulation.exercises.P05_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<String, Team> teams = new HashMap<>();

        String input;
        while (!"END".equals(input = reader.readLine())) {
            String[] tokens = input.trim().split(";");
            String command = tokens[0];
            String nameOfTeam = tokens[1];
            String nameOfPlayer;

            switch (command) {
                case "Team":
                    try {
                        Team team = new Team(nameOfTeam);
                        teams.putIfAbsent(nameOfTeam, team);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    if (!teams.containsKey(nameOfTeam)) {
                        System.out.printf("Team %s does not exist.%n", nameOfTeam);
                    } else {
                        try {
                            nameOfPlayer = tokens[2];
                            int endurance = Integer.parseInt(tokens[3]);
                            int sprint = Integer.parseInt(tokens[4]);
                            int dribble = Integer.parseInt(tokens[5]);
                            int passing = Integer.parseInt(tokens[6]);
                            int shooting = Integer.parseInt(tokens[7]);

                            Player player = new Player(nameOfPlayer, endurance, sprint, dribble, passing, shooting);
                            teams.get(nameOfTeam).addPlayer(player);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Remove":
                    try {
                        nameOfPlayer = tokens[2];
                        teams.get(nameOfTeam).removePlayer(nameOfPlayer);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Rating":
                    if (!teams.containsKey(nameOfTeam)) {
                        System.out.printf("Team %s does not exist.%n", nameOfTeam);
                    } else {
                        System.out.printf("%s - %.0f%n", nameOfTeam, (teams.get(nameOfTeam).getRating()));
                    }
                    break;
                default:
                    break;
            }
        }
    }
}