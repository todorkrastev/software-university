package Controllers;

import Exercises.*;
import Include.ExercisesImp;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

import static Include.CoreMessages.*;
import static Include.ExercisesMessages.*;

public class ExerciseController {
    private Map<Integer,String> exerciseNames;
    private Map<Integer, ExercisesImp> exercisesPathes;
    private Connection connection;

    public ExerciseController(Connection connection){
        exerciseNames = new LinkedHashMap<>();
        exercisesPathes = new LinkedHashMap<>();
        this.connection = connection;
        inputValues();
    }

    public void infoText(){
        System.out.print(RULES);
        this.getExerciseNames().forEach((key, value) -> System.out.printf(INFO_TEXT, key, value));
        System.out.println();}


   public ExercisesImp getExercise (int pick){
        return exercisesPathes.get(pick);
   }

   public String getExerciseName(int pick){
        return exerciseNames.get(pick);
    }

    public Map<Integer, String> getExerciseNames() {
        return exerciseNames;
    }

    private void inputValues(){
        exerciseNames.put(1,EXERCISE1);
        exerciseNames.put(2,EXERCISE2);
        exerciseNames.put(3,EXERCISE3);
        exerciseNames.put(4,EXERCISE4);
        exerciseNames.put(5,EXERCISE5);
        exerciseNames.put(6,EXERCISE6);
        exerciseNames.put(7,EXERCISE7);
        exerciseNames.put(8,EXERCISE8);
        exerciseNames.put(9,EXERCISE9);


        exercisesPathes.put(1, new Exercise1());
        exercisesPathes.put(2, new Exercise2());
        exercisesPathes.put(3, new Exercise3());
        exercisesPathes.put(4, new Exercise4());
        exercisesPathes.put(5, new Exercise5());
        exercisesPathes.put(6, new Exercise6());
        exercisesPathes.put(7, new Exercise7());
        exercisesPathes.put(8, new Exercise8());
        exercisesPathes.put(9, new Exercise9());

    }
}
