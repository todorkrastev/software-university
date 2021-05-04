import java.text.DecimalFormat;
import java.util.Scanner;

public class E08MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        {

            double inputNum = Double.parseDouble(scanner.nextLine());
            double powerNum = Double.parseDouble(scanner.nextLine());

            System.out.println(new DecimalFormat("0.####")
                    .format(getPowerNum(inputNum, powerNum)));
        }
    }

    public static double getPowerNum(double num, double power) {
        return Math.pow(num, power);
    }
}

