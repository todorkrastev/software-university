package bg.softuni.java_advanced.defining_classes.lab.P03_BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        Map<Integer, BankAccount> bankAccountInfo = new HashMap<>();

        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String output = null;

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccountInfo.put(bankAccount.getId(), bankAccount);
                    output = String.format("Account ID%d created", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    if (bankAccountInfo.containsKey(id)) {
                        bankAccountInfo.get(id).deposit(amount);
                        output = String.format("Deposited %d to ID%d", amount, id);
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double newInterestRate = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(newInterestRate);
                    output = null;
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (bankAccountInfo.containsKey(id)) {
                        double interest = bankAccountInfo.get(id).getInterest(years);
                        output = String.format("%.2f", interest);
                    } else {
                        output = "Account does not exist";
                    }
                    break;
            }
            if (output != null) {
                System.out.println(output);
            }
        }
    }
}
