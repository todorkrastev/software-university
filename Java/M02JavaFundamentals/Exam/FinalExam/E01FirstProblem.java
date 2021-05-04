package FinalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class E01FirstProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));

        String email = reader.readLine();


        String input;
        while (!"Complete".equals(input = reader.readLine())) {
            // trim ??? \\s+??
            String[] split = input.trim().split("\\s+");
            String command = split[0];

            switch (command) {
                case "Make":
                    // if it does not word properly, try to make with if else because you can receive as an input only MAKE
                    String upperLower = split[1];

                    switch (upperLower) {
                        case "Upper":
                            email = email.toUpperCase();
                            System.out.println(email);
                            break;
                        case "Lower":
                            email = email.toLowerCase();
                            System.out.println(email);
                            break;
                        default:
                            // System.out.println(email); ??????
                            break;
                    }
                    break;
                case "GetDomain":
                    int count = Integer.parseInt(split[1]);

                    String domain = email.substring(email.length() - count);
                    System.out.println(domain);
                    break;
                case "GetUsername":
                    String symbol = "@";
                    int username = email.indexOf(symbol);

                    if (!email.contains(symbol)) {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    } else {
                        System.out.println(email.substring(0, username));
                    }
                    break;
                case "Replace":
                    // if it does not work, try to switch String with char!!!
                    // if it does not work properly, use Pattern.quote
                    String ch = split[1];

                    email = email.replace(ch, "-");
                    System.out.println(email);
                    break;
                case "Encrypt":
                    for (int i = 0; i < email.length(); i++) {
                        char currSymbol = email.charAt(i);
                        int currDigit = (int) currSymbol;

                        if (i != email.length() - 1) {
                            System.out.print(currDigit + " ");
                        } else {
                            System.out.println(currDigit);
                        }
                    }
                    break;
                default:
                    // System.out.println(email); ????
                    break;
            }
        }
    }
}
