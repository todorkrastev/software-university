package bg.softuni.programming_basics.conditional_statements.lab;

import java.util.Scanner;

public class E06AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfFigure = scanner.nextLine();
        switch (typeOfFigure) {
            case "square":
                double sideSqaure = Double.parseDouble(scanner.nextLine());
                double areaOfSquare = sideSqaure * sideSqaure;
                System.out.printf("%.3f%n", areaOfSquare);
                break;
            case "rectangle":
                double sideRectangleA = Double.parseDouble(scanner.nextLine());
                double sideRectangleB = Double.parseDouble(scanner.nextLine());
                double areaOfRectangle = sideRectangleA * sideRectangleB;
                System.out.printf("%.3f%n", areaOfRectangle);
                break;
            case "circle":
                double radiusOfCircle = Double.parseDouble(scanner.nextLine());
                double areaOfCircle = Math.PI * radiusOfCircle * radiusOfCircle;
                System.out.printf("%.3f%n", areaOfCircle);
                break;
            case "triangle":
                double sideOfTriangle = Double.parseDouble(scanner.nextLine());
                double heightOfTriangle = Double.parseDouble(scanner.nextLine());
                double areaOfTriangle = (sideOfTriangle * heightOfTriangle) / 2;
                System.out.printf("%.3f%n", areaOfTriangle);
                break;
            default:
                System.out.println("Insert correct information!");
                break;
        }
    }
}
