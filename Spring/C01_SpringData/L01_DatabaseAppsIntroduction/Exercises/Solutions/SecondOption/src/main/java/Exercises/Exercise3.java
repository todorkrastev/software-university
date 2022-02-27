package Exercises;

import Include.ExercisesImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static Include.ExercisesMessages.*;

public class Exercise3 implements ExercisesImp {
    private ResultSet resultSet;
    private int id;

    @Override
    public void run(Connection connection) {

        fillResultSetFromMysql(connection);
        printResults();

    }

    private void printResults() {
        try {
            int counter = 1;
                while (resultSet.next()) {
                    if (counter == 1) {
                        System.out.printf("Villain: %s\n", resultSet.getString("v.name"));
                    }
                    System.out.printf("%s. %s %s\n", counter++, resultSet.getString("m.name"), resultSet.getString("m.age"));
                }

            if(counter==1){
                System.out.printf(INVALID_VILLAINS_NUMBER,id);
            }
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void fillResultSetFromMysql(Connection connection) {
        try{
            System.out.println(ENTER_VILLAIN_ID);
             id = Integer.parseInt(new Scanner(System.in).nextLine());

            PreparedStatement stete = connection.prepareStatement("SELECT DISTINCT * \n" +
                    "FROM `villains` as v \n" +
                    "JOIN `minions_villains` as mv \n" +
                    "ON mv.`villain_id` = v . `id`\n" +
                    "JOIN `minions` AS m ON mv.`minion_id`=m.`id`\n" +
                    "WHERE v.`id`= ?;");

            stete.setInt(1,id);
            resultSet = stete.executeQuery();

        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
