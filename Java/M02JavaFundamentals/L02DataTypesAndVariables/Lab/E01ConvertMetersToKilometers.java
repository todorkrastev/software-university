import java.util.Scanner;

public class E01ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputMeters = Integer.parseInt(scanner.nextLine());
        double metersToKm = (double)inputMeters / 1000;

        System.out.printf("%.2f", metersToKm);
    }
}
