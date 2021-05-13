package bg.softuni.programming_basics.conditional_statements.lab;

import java.util.Scanner;

public class E01ExcellentResult {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double rating = Double.parseDouble(scan.nextLine());

        if (rating >= 5.50) {
            System.out.println("Excellent!");
        }
    }
}
