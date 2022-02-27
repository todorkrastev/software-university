package Controllers;

import Connector.DBConnector;

import java.util.Scanner;

import static Include.CoreMessages.*;


public class Controller {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        DBConnector dataBase = new DBConnector();
        String input;

        while(true) {
            ExerciseController exercises = new ExerciseController(dataBase.getConnection());
            exercises.infoText();
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("stop")){
                break;
            }
            try {
                int pick = Integer.parseInt(input);
                String exerciseName = exercises.getExerciseName(pick);
                if (exerciseName==null){
                    throw new IllegalArgumentException(INVALID_INPUT);
                }
                System.out.printf("Selected exercise is %S.%n", exerciseName);
                System.out.println(SEPARATOR);
                exercises.getExercise(pick).run(dataBase.getConnection());

                System.out.println(SEPARATOR);
            }catch (NumberFormatException e){
                System.out.println("ERROR:"  + INVALID_INPUT);
            }catch (IllegalArgumentException s){
                System.out.println("ERROR: " + s.getMessage());
            }
        }
        dataBase.close();
    }
}
