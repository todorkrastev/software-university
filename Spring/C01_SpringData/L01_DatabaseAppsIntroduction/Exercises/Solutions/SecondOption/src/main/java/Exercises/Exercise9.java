package Exercises;

import Include.ExercisesImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static Include.CoreMessages.*;
import static Include.ExercisesMessages.*;

public class Exercise9 implements ExercisesImp {
    private Connection connection;
    private int id;

    @Override
    public void run(Connection connection) {
        this.connection = connection;
            createProcedure();
            setID();
            increaseID();
            printResult();
            dropProcedure();

    }

    private void printResult() {
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT `name`,`age` FROM `minions` WHERE `id`=?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                System.out.printf("%s %s%n",resultSet.getString("name"),resultSet.getString("age"));
            }
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void increaseID() {
        try{
            PreparedStatement statement = connection.prepareStatement("call usp_get_older(?)");
            statement.setInt(1,id);
            if(statement.executeUpdate()==0){
                dropProcedure();
                throw new IllegalArgumentException(INVALID_INDEX);
            }
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void setID() {
        System.out.println(ENTER_ID_FOR_INCREASE);
        try {
            id = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e){
            dropProcedure();
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }

    private void dropProcedure() {
        try{
            PreparedStatement statement = connection.prepareStatement("DROP PROCEDURE `usp_get_older` ");
            statement.execute();
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void createProcedure() {
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "CREATE PROCEDURE `usp_get_older`(`minionId` INT)\n" +
                    "BEGIN\n" +
                    "UPDATE `minions` SET `age` = `age` + 1 WHERE `id`=`minionId`;\n" +
                    "END");

            statement.execute();
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
