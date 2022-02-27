package Exercises;

import Include.ExercisesImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static Include.ExercisesMessages.*;
import static Include.CoreMessages.*;


public class Exercise8 implements ExercisesImp {
    private final Scanner scanner;
    private final List<Integer> IDs;
    private Connection connection;

    public Exercise8() {
        scanner = new Scanner(System.in);
        IDs = new ArrayList<>();
    }

    @Override
    public void run(Connection connection) {
        this.connection = connection;
        readIDs();
        increaseAge();
        System.out.println(SEPARATOR);
        printResults();
    }

    private void printResults() {
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT `name`,`age` FROM `minions`");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                System.out.printf("%s %s%n",resultSet.getString("name"),resultSet.getString("age"));
            }
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void increaseAge() {
        for (Integer id : IDs) {
            increaseOneAge(id);
        }
    }

    private void increaseOneAge(int idForReworking) {
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE `minions` SET `age`=`age`+1,`name` = LOWER(`name`) WHERE `id`=?");
            statement.setInt(1,idForReworking);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void readIDs() {
        System.out.println(ENTER_IDS);
        IDs.addAll(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
    }
}
