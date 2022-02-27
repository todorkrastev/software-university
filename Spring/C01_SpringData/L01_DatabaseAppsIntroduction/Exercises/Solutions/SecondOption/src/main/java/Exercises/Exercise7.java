package Exercises;

import Include.ExercisesImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exercise7 implements ExercisesImp {
    private Connection connection;
    private int first_id;
    private int last_id;
    private int count;

    @Override
    public void run(Connection connection) {
        this.connection = connection;
        setStartIds();
        while(count>0){
            System.out.println(getMinionName(first_id));
            System.out.println(getMinionName(last_id));
            first_id++;
            last_id--;
            count --;
        }
    }

    private void setStartIds() {
        first_id = 1;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT `id` FROM `minions` ORDER BY id DESC LIMIT 1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                last_id = Integer.parseInt(resultSet.getString("id"));
                count = last_id/2;
            }
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private String getMinionName(int id) {
        String name = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT `name` FROM `minions` WHERE id = ?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                name = resultSet.getString("name");
            }
        }catch (SQLException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        return name;
    }
}
