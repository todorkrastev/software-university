package Exercises;

import Include.ExercisesImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exercise2 implements ExercisesImp {
    private ResultSet resultSet;

    @Override
    public void run(Connection connection) {
        fillResultSetFromMysql(connection);
        getResults();
    }

    private void getResults() {
        try {
            while (resultSet.next()) {
                System.out.printf("%s %s\n", resultSet.getString("name"), resultSet.getString("count"));
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void fillResultSetFromMysql(Connection connection) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT DISTINCT v.`name`, COUNT(DISTINCT mv.`minion_id`) as `count`\n" +
                            "FROM `villains` as v\n" +
                            "JOIN `minions_villains` as mv ON mv.`villain_id` = v . `id`\n" +
                            "GROUP BY v.`id`\n" +
                            "HAVING `count`>15\n" +
                            "ORDER BY `count` DESC;");

            resultSet = stmt.executeQuery();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
