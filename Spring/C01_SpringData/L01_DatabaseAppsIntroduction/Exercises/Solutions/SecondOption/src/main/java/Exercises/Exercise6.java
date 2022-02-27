package Exercises;

import Include.ExercisesImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static Include.ExercisesMessages.*;
import static Include.CoreMessages.*;

public class Exercise6 implements ExercisesImp {
    private int countUpdatedMinions;
    private Connection connection;
    private Scanner scanner;
    private int villainID;
    private String villainName;

    public Exercise6() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void run(Connection connection) {
        this.connection = connection;
        try {
            setVillainID();
            System.out.println(SEPARATOR);
            setVillainName();
            updateMinions_VillainsTable();
            deleteVillain();
            System.out.printf(MINIONS_RELEASED,countUpdatedMinions);
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }

    private void deleteVillain() {
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM `villains` WHERE id= ?");
            statement.setInt(1,villainID);
            statement.execute();
            System.out.printf(VILLAIN_DELETED,villainName);
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void updateMinions_VillainsTable() {
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE `minions_villains` SET villain_id = null where villain_id = ?");
            statement.setInt(1,villainID);
            countUpdatedMinions = statement.executeUpdate();
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void setVillainName() {
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT `name` FROM `villains` WHERE `id` = ?");
            statement.setInt(1,villainID);
            ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    villainName = resultSet.getString("name");
                }

            if(villainName == null){
                throw new IllegalStateException(VILLAIN_NOT_FOUND);
            }

        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void setVillainID() {
        System.out.println(ENTER_VILLAIN_ID);
        villainID = Integer.parseInt(scanner.nextLine());
    }
}
