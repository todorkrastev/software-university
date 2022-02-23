import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final String CONNECTION_STRING =
            "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "minions_db";
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Connection connection;
    private static int exerciseDigit;
    private static String reply;


    public static void main(String[] args) throws SQLException, IOException {

        connection = getConnection();

        System.out.println("""
                Hello there!
                Please select the desired exercise
                Hint: Desired exercise -> Exercise 2 -> enter -> 2""");


        enterDesiredExercise();

        do {
            switch (exerciseDigit) {
                case 2 -> {
                    System.out.println("Selected Exercise -> 2.Get Villains’ Names");
                    p02_GetVillainsNames();
                }
                case 3 -> {
                    System.out.println("Selected Exercise -> 3.Get Minion Names");
                    p03_GetMinionNames();
                }
                case 4 -> {
                    System.out.println("Selected Exercise -> 4.Add Minion");
                    p04_AddMinion();
                }
                case 5 -> {
                    System.out.println("Selected Exercise -> 5.Change Town Names Casing");
                    p05_ChangeTownNamesCasing();
                }
                case 6 -> {
                    System.out.println("Selected Exercise -> 6.Remove Villain");
                    p06_RemoveVillain();
                }
                case 7 -> {
                    System.out.println("Selected Exercise -> 7.Print All Minion Names");
                    p07_PrintAllMinionNames();
                }
                case 8 -> {
                    System.out.println("Selected Exercise -> 8.Increase Minions Age");
                    p08_IncreaseMinionsAge();
                }
                case 9 -> {
                    System.out.println("Selected Exercise -> 9.Increase Age Stored Procedure");
                    p09_IncreaseAgeStoredProcedure();
                }
                default -> exerciseDigit = 0;
            }

            reply = runProgram();

            if (stopProgram()) break;

            if (digitOutOfBounds()) {
                whileInputIsNotValid();
            } else {
                System.out.println("\nPlease select the desired exercise");
                enterDesiredExercise();
            }


        } while (reply.equalsIgnoreCase("y"));
    }

    private static void p09_IncreaseAgeStoredProcedure() throws IOException, SQLException {
        System.out.println("Enter Minion's ID");
        int minionId = Integer.parseInt(reader.readLine());

        String minionName = getEntityNameById(minionId);

        if (minionName == null) {
            System.out.printf("There is no minion with ID: %d%n", minionId);
        } else {
            CallableStatement callableStatement = connection.prepareCall("CALL usp_get_older(?)");
            callableStatement.setInt(1, minionId);
            callableStatement.execute();

            printMinionById(minionId);
        }
    }

    private static void p08_IncreaseMinionsAge() throws IOException, SQLException {
        System.out.println("Enter Minion's ID");

        List<Integer> minionsIdsList = Arrays.stream(reader.readLine().trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        minionsIdsList.forEach(e -> {
            try {
                increaseMinionAgeById(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        printMinions();
    }

    private static void p07_PrintAllMinionNames() throws SQLException {
        String query = "SELECT name FROM minions; ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> minionsNameList = new ArrayList<>();

        while (resultSet.next()) {
            minionsNameList.add(resultSet.getString("name"));
        }

        while (minionsNameList.iterator().hasNext()) {
            System.out.println(minionsNameList.get(0));
            minionsNameList.remove(0);
            if (!minionsNameList.isEmpty()) {
                System.out.println(minionsNameList.get(minionsNameList.size() - 1));
                minionsNameList.remove(minionsNameList.size() - 1);
            }
        }
    }

    private static void p06_RemoveVillain() throws IOException, SQLException {
        System.out.println("Enter Villain's ID");
        int villainId = Integer.parseInt(reader.readLine());

        String villainName = getEntityNameById(villainId);

        StringBuilder output = new StringBuilder();
        if (villainName == null) {
            output.append("No such villain was found");
        } else {
            int releasedMinions = releaseMinionById(villainId);
            deleteVillainById(villainId);
            output
                    .append(villainName)
                    .append(" was deleted")
                    .append(System.lineSeparator())
                    .append(releasedMinions)
                    .append(" minions released");
        }

        System.out.println(output);
        output.setLength(0);
    }

    private static void p05_ChangeTownNamesCasing() throws IOException, SQLException {
        System.out.println("Enter Desired Country");
        String countryName = reader.readLine();

        int countryNameId = getEntityIdByCountry(countryName);

        if (countryNameId == -1) {
            System.out.println("No town names were affected.");
        } else {
            String query = "UPDATE towns SET name = UPPER(name) WHERE country = ?; ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, countryName);
            preparedStatement.execute();

            printCitiesWithUpperCase(countryName);
        }
    }

    private static void p04_AddMinion() throws IOException, SQLException {
        System.out.println("""
                Enter Desired Minion
                Example -> Minion: Robert 14 Berlin""");
        String[] minionSplit = reader.readLine().split(":\\s+");
        String nameM = minionSplit[1].split("\\s+")[0];
        int ageM = Integer.parseInt(minionSplit[1].split("\\s+")[1]);
        String townM = minionSplit[1].split("\\s+")[2];

        int townId = getEntityIdByName(townM, "towns");

        if (townId == -1) {
            insertEntityInTowns(townM);
            townId = getEntityIdByName(townM, "towns");
        }

        int nameMinionId = getEntityIdByName(nameM, "minions");

        if (nameMinionId == -1) {
            insertEntityInMinions(nameM, ageM, townId);
            System.out.printf("Minion %s at the age of %d from %s was added to the database.%n", nameM, ageM, townM);
            nameMinionId = getEntityIdByName(nameM, "minions");
        }

        System.out.println("""
                Enter Desired Villain
                Example -> Villain: Gru""");
        String[] villainSplit = reader.readLine().split(":\\s+");
        String nameV = villainSplit[1].split("\\s+")[0];

        int nameVillainId = getEntityIdByName(nameV, "villains");

        if (nameVillainId == -1) {
            insertEntityInVillains(nameV);
            nameVillainId = getEntityIdByName(nameV, "villains");
        }

        insertEntitiesInMinionsVillains(nameMinionId, nameVillainId);
        System.out.printf("Successfully added %s to be minion of %s.%n", nameM, nameV);
    }

    private static void p03_GetMinionNames() throws SQLException, IOException {
        System.out.println("Enter Villain's ID:");
        int villainId = Integer.parseInt(reader.readLine());
        String villainName = getEntityNameById(villainId);

        if (villainName == null) {
            System.out.printf("No villain with ID %d exists in the database.%n", villainId);
            return;
        }

        System.out.println("Villain: " + villainName);

        Set<String> allMinionsByGivenVillainName = getAllMinionsByGivenVillainName(villainName);

        allMinionsByGivenVillainName.forEach(System.out::println);
    }

    private static void p02_GetVillainsNames() throws SQLException, IOException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT v.`name`, COUNT(DISTINCT mv.`minion_id`) AS `number_of_minions` " +
                        "FROM `villains` AS v " +
                        "JOIN `minions_villains` AS mv ON v.`id` = mv.`villain_id` " +
                        "WHERE v.`id` IN (SELECT `villain_id` FROM `minions_villains`) " +
                        "GROUP BY v.`id` " +
                        "HAVING `number_of_minions` > ? " +
                        "ORDER BY `number_of_minions` DESC; ");

        System.out.println("Enter Number of Minions:");

        int numOfMinions = Integer.parseInt(reader.readLine());

        preparedStatement.setInt(1, numOfMinions);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d %n", resultSet.getString("name"), resultSet.getInt(2));
        }
    }

    private static void printMinionById(int minionId) throws SQLException {
        String query = "SELECT name, age FROM minions WHERE id = ?; ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, minionId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("name"), resultSet.getInt("age"));
        }
    }

    private static void printMinions() throws SQLException {
        String query = "SELECT name, age FROM minions; ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n",
                    resultSet.getString("name"),
                    resultSet.getInt("age"));
        }
    }

    private static void increaseMinionAgeById(Integer id) throws SQLException {
        String query = "UPDATE minions SET age = age + 1, name = LOWER(name) WHERE id = ?; ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    private static int releaseMinionById(int id) throws SQLException {
        String query = "DELETE FROM minions_villains WHERE villain_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        return preparedStatement.executeUpdate();
    }

    private static void deleteVillainById(int id) throws SQLException {
        String query = "DELETE FROM villains WHERE id = ?; ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    private static void printCitiesWithUpperCase(String countryName) throws SQLException {
        String query = "SELECT name FROM towns WHERE country = ?; ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, countryName);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<String> townsList = new ArrayList<>();

        while (resultSet.next()) {
            townsList.add(resultSet.getString("name"));
        }

        String result = townsList.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.printf("%d town names were effected.%n", townsList.size());
        System.out.println(result);
    }

    private static void insertEntitiesInMinionsVillains(int nameMinionId, int nameVillainId) throws SQLException {
        String query = "INSERT INTO minions_villains (minion_id, villain_id) VALUES (?, ?); ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, nameMinionId);
        preparedStatement.setInt(2, nameVillainId);
        preparedStatement.execute();
    }

    private static void insertEntityInMinions(String nameM, int ageM, int townId) throws SQLException {
        String query = "INSERT INTO `minions` (`name`, `age`, `town_id`) VALUES (?, ?, ?); ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nameM);
        preparedStatement.setInt(2, ageM);
        preparedStatement.setInt(3, townId);
        preparedStatement.execute();
    }

    private static void insertEntityInVillains(String nameV) throws SQLException {
        String evilnessFactor = "evil";
        String query = "INSERT INTO `villains` (`name`, `evilness_factor`) VALUES (?, ?); ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nameV);
        preparedStatement.setString(2, evilnessFactor);
        preparedStatement.execute();

        System.out.printf("Villain %s was added to the database.%n", nameV);
    }

    private static void insertEntityInTowns(String townM) throws SQLException {
        String query = "INSERT INTO towns (`name`) VALUES (?); ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, townM);
        preparedStatement.execute();

        System.out.printf("Town %s was added to the database.%n", townM);
    }

    private static int getEntityIdByCountry(String entityName) throws SQLException {
        String query = String.format("SELECT `id` FROM %s WHERE `country` = ?", "towns");

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, entityName);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next() ? resultSet.getInt(1) : -1;
    }

    private static int getEntityIdByName(String entityName, String tableName) throws SQLException {
        String query = String.format("SELECT `id` FROM %s WHERE `name` = ?", tableName);

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, entityName);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next() ? resultSet.getInt(1) : -1;
    }

    private static String getEntityNameById(int entityId) throws SQLException {
        String query = String.format("SELECT name FROM %s WHERE id = ?", "villains");
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, entityId);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet.next() ? resultSet.getString("name") : null;
    }

    private static Set<String> getAllMinionsByGivenVillainName(String villainName) throws SQLException {
        Set<String> minionsSet = new LinkedHashSet<>();
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT m.`name`, m.`age` " +
                        "FROM `minions` AS m " +
                        "JOIN minions_villains AS mv on m.`id` = mv.`minion_id` " +
                        "WHERE mv.`villain_id` = (SELECT `id` FROM villains WHERE `name` = ?); ");


        preparedStatement.setString(1, villainName);

        ResultSet resultSet = preparedStatement.executeQuery();

        int counter = 0;
        while (resultSet.next()) {
            minionsSet
                    .add(String.format("%d. %s %d", ++counter,
                            resultSet.getString("name"),
                            resultSet.getInt("age")));
        }

        return minionsSet;
    }

    private static boolean stopProgram() throws SQLException {
        if (reply.equals("n")) {
            System.out.println("\n\nThank you for spending your time exploring my code!\n\n");

            connection.close();

            return true;
        }
        return false;
    }

    private static String runProgram() throws IOException {
        String answer;
        do {
            System.out.println("\nDo you want to run some other exercises: [Y/N]");
            answer = reader.readLine().toLowerCase();
        } while (!answer.equals("y") && !answer.equals("n"));

        return answer;
    }

    private static void enterDesiredExercise() {
        try {
            exerciseDigit = Integer.parseInt(reader.readLine());
            whileInputIsNotValid();
        } catch (Exception e) {
            System.out.println("The input is not a valid integer");
            exerciseDigit = 0;
            whileInputIsNotValid();
        }
    }

    private static void whileInputIsNotValid() {
        while (digitOutOfBounds()) {
            try {
                System.out.println("Please enter digit between 2 and 9");
                exerciseDigit = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                whileInputIsNotValid();
            }
        }
    }

    private static boolean digitOutOfBounds() {
        return exerciseDigit < 2 || exerciseDigit > 9;
    }

    private static Connection getConnection() throws IOException, SQLException {
        System.out.println("Enter Your Username:");
        String user = reader.readLine().equals("") ? "root" : reader.readLine();
        System.out.println("Enter Your Password:");
        String password = reader.readLine().equals("") ? "V170sh@229O" : reader.readLine();

        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        return DriverManager
                .getConnection(CONNECTION_STRING + DB_NAME, properties);
    }
}
