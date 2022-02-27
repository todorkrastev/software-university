package Exercises;

import Include.ExercisesImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Include.ExercisesMessages.*;

public class Exercise5 implements ExercisesImp {
    private String countryName;
    private Scanner scanner;
    private Connection connection;
    private List<String>names;
    private int count;

    public Exercise5() {
        scanner = new Scanner(System.in);
        names = new ArrayList<>();
    }

    @Override
    public void run(Connection connection) {
        this.connection = connection;
        setCountryName();

        try {
            getAffectedTownsCount();
            getNamesOfAffectedTowns();
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }

    }


    private void getNamesOfAffectedTowns() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `name` FROM `towns` WHERE country = ?");
            statement.setString(1,countryName);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                names.add(resultSet.getString("name"));
            }

            System.out.println(names);

        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void getAffectedTownsCount() {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE `towns` SET `name` = UPPER(`name`) WHERE country = ?");
            statement.setString(1,countryName);
            count = statement.executeUpdate();
            if(count==0){
                throw new IllegalStateException(NO_TOWNS_TO_AFFECT);
            }else {
                System.out.printf(AFFECTED_TOWN_NAMES,count);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void setCountryName () {
        System.out.println(INPUT_COUNTRY_NAME);
        countryName = scanner.nextLine();
    }
}
