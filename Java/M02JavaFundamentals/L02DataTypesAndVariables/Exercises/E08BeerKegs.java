import java.util.Scanner;

public class E08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte n = Byte.parseByte(scanner.nextLine());
        double volume = 0.0;
        double maxNum = Double.MIN_VALUE;
        String biggestKeg = "";

        for (int i = 0; i < n; i++) {
            String typeOfKeg = scanner.nextLine();
            float radius = Float.parseFloat(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            volume = Math.PI * radius * radius * height;

            if (maxNum < volume){
                maxNum = volume;
                biggestKeg = typeOfKeg;
            }
        }
        System.out.println(biggestKeg);
    }
}
