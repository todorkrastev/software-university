package bg.softuni.java_oop.working_with_abstraction.exercises.P04_TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] trafficLights = scanner.nextLine().trim().split("\\s+");
        int numOfUpdatesOfTrafficLight = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfUpdatesOfTrafficLight; i++) {
            StringBuilder output = new StringBuilder();
            for (int j = 0; j < trafficLights.length; j++) {
                String currLight = trafficLights[j];
                StateMachine stateMachine = StateMachine.valueOf(currLight);
                trafficLights[j] = String.valueOf(StateMachine.update(stateMachine));
                output
                        .append(trafficLights[j])
                        .append(" ");
            }
            System.out.println(output.toString().trim());
        }
    }
}
