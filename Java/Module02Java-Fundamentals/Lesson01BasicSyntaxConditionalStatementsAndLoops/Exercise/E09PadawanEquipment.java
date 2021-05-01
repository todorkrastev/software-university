import java.util.Scanner;

public class E09PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        double priceSabers = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());

        double extraSabers = Math.ceil(countOfStudents * 1.10);
        int countOfStudentsBelts = 0;

        double result = priceSabers * extraSabers + priceRobes * countOfStudents + priceBelts * countOfStudents;
        countOfStudentsBelts = countOfStudents;

        for (int i = 1; i <= countOfStudents; i++) {
            if (i % 6 == 0) {
                countOfStudentsBelts -= 1;
                result = 0.0;
                result = priceSabers * extraSabers + priceRobes * countOfStudents + priceBelts * countOfStudentsBelts;
            }
        }

        if (result <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", result);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", Math.abs(money - result));
        }
    }
}
