import java.util.Scanner;

public class E10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int powerN = Integer.parseInt(scanner.nextLine());
        int distanceM = Integer.parseInt(scanner.nextLine());
        byte exhaustionY = Byte.parseByte(scanner.nextLine());

        double halfOrginialValue = powerN * 0.5;

        int count = 0;

        while (powerN >= distanceM) {
            count++;
            powerN -= distanceM;
            if (halfOrginialValue == powerN && exhaustionY > 0) {
                powerN /= exhaustionY;
            }
        }
        System.out.println(powerN);
        System.out.println(count);
    }
}

