package Exercises;

import Include.ExercisesImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static Include.CoreMessages.SEPARATOR;
import static Include.ExercisesMessages.*;

public class Exercise4 implements ExercisesImp {
    private final Scanner scanner;
    private String minionName;
    private int minionAge;
    private String minionTown;
    private String villain;
    private int minionID;
    private int villainID;
    private int townID;
    private boolean isTownExist;
    private boolean isVillainExist;
    private boolean isMinionExist;


    public Exercise4() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void run(Connection connection) {
        fillLocalData();

        System.out.println(SEPARATOR);
        importToMysqlMissingParts(connection);
        addMinionToVillain(connection);
    }

    private void fillLocalData(){
        System.out.println(MINION_ENTRY);
        String [] splitMinions = scanner.nextLine().split(" ");

        if(splitMinions[0].equals("Minion:")) {
            minionName = splitMinions[1];
            minionAge = Integer.parseInt(splitMinions[2]);
            minionTown = splitMinions[3];
        }else{
            throw new IllegalArgumentException(INVALID_MINION_ENTRY);
        }
        System.out.println(VILLAIN_ENTRY);
        String [] splitVillain = scanner.nextLine().split(" ");
        if(splitVillain[0].equals("Villain:")) {
            villain = splitVillain[1];
        } else{
            throw new IllegalArgumentException(INVALID_Villain_ENTRY);
        }
    }

    private void importToMysqlMissingParts(Connection connection) {

        checker(connection);
        if(!isTownExist) {
            importTown(connection);
            System.out.printf(TOWN_IMPORTED,minionTown);
        }

        if(!isVillainExist){
            importVillain(connection);
            System.out.printf(VILLAIN_IMPORTED,villain);
        }
        getID(connection);

        if(!isMinionExist) {
            importMinion(connection);
        }
        getID(connection);
    }

    private void importMinion(Connection connection) {
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO `minions` ( `name`, `age`, `town_id`) " +
                            "VALUES (? , ? , ? )"
            );

            statement.setString(1,minionName);
            statement.setInt(2,minionAge);
            statement.setInt(3,townID);

            statement.execute();
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void importVillain(Connection connection) {
        try {
            PreparedStatement state = connection.prepareStatement("INSERT INTO villains (`name`,`evilness_factor`) VALUES(?,'evil')");

            state.setString(1,villain);
            state.executeUpdate();

        }catch(SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void importTown(Connection connection){
        try {
            PreparedStatement state = connection.prepareStatement("INSERT INTO towns (`name`) VALUES( ? )");
            state.setString(1, minionTown);
            state.execute();

        }catch(SQLException e){
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    private void addMinionToVillain(Connection connection) {
       if(!checkMinions_villainsTable(connection,minionID,villainID)) {
           try {
               PreparedStatement statement = connection.prepareStatement(
                       "INSERT INTO `minions_villains` (`minion_id`,`villain_id`) VALUES ( ?,?)");
               statement.setInt(1,minionID);
               statement.setInt(2,villainID);
               statement.execute();
               System.out.printf(ADD_MINION_TO_VILLAIN_VALID, minionName, villain);
           } catch (SQLException e) {
               throw new IllegalArgumentException(e.getMessage());
           }
       }else{
           throw new IllegalArgumentException(String.format(ADD_MINION_TO_VILLAIN_INVALID,minionName,villain));
       }
    }

    private void getID(Connection connection) {
        try{
            PreparedStatement minionStatement = connection.prepareStatement("SELECT `id` FROM `minions` WHERE `name` = ?");
            PreparedStatement townStatement = connection.prepareStatement("SELECT `id` FROM `towns` WHERE `name` = ?");
            PreparedStatement villainStatement = connection.prepareStatement("SELECT `id` FROM `villains` WHERE `name` = ?");
            minionStatement.setString(1,minionName);
            townStatement.setString(1,minionTown);
            villainStatement.setString(1,villain);

            ResultSet minionResults = minionStatement.executeQuery();
            ResultSet townResults = townStatement.executeQuery();
            ResultSet villainResults = villainStatement.executeQuery();

            while(minionResults.next()){
                minionID = Integer.parseInt(minionResults.getString("id"));
            }

            while(townResults.next()){
                townID = Integer.parseInt(townResults.getString("id"));
            }

            while(villainResults.next()){
                villainID = Integer.parseInt(villainResults.getString("id"));
            }



        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private boolean checkMinions_villainsTable(Connection connection, int minionID, int villainID) {
        try {
            PreparedStatement state = connection.prepareStatement("" +
                    "SELECT `minion_id` FROM `minions_villains` WHERE `minion_id` = ? AND `villain_id` = ?");

            state.setInt(1, minionID);
            state.setInt(2, villainID);
            ResultSet results = state.executeQuery();

            if(!results.next()){
                return false;
            }
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }

        return true;
    }

    private void checker(Connection connection){
        try {
            PreparedStatement minionState = connection.prepareStatement("SELECT `name` FROM `minions` WHERE `name` = ?");
            PreparedStatement villainState = connection.prepareStatement("SELECT `name` FROM `villains` WHERE `name` = ?");
            PreparedStatement townState = connection.prepareStatement("SELECT `name` FROM `towns` WHERE `name` = ?");

            minionState.setString(1,minionName);
            villainState.setString(1,villain);
            townState.setString(1,minionTown);

            ResultSet minionResult = minionState.executeQuery();
            ResultSet villainResult = villainState.executeQuery();
            ResultSet townResult = townState.executeQuery();

            isMinionExist = minionResult.next();
            isVillainExist = villainResult.next();
            isTownExist = townResult.next();

        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
