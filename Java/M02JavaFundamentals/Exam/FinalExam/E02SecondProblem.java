package FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02SecondProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        int n = Integer.parseInt(reader.readLine());
        int count = 0;

        // check the regEx - (U\$) or \1, if it does not work properly
        // same topic - (P@\$) or \4
        // minimum 5 alphabetical letters - could be \\w+ ^[0-9]_ !!!

        String regEx = "(U\\$)(?<username>[A-Z][a-z]{2,})(U\\$)(P@\\$)(?<password>[A-Za-z]{5,}\\d+)(P@\\$)";
        Pattern pattern = Pattern.compile(regEx);

        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            Matcher matcher = pattern.matcher(input);


            if (matcher.find()) {
                String username = matcher.group("username");
                String password = matcher.group("password");

                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", username, password);

                // if it does not work properly, try with count++ instead of list!!!
               count++;
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.printf("Successful registrations: %d%n", count);
    }
}
