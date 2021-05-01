import java.util.Scanner;

public class E03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleNum = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0.0;
        int discount = 0;

        switch (groupType) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        if (30 <= peopleNum)
                            price *= 0.85;
                        break;
                    case "Saturday":
                        price = 9.8;
                        if (30 <= peopleNum)
                            price *= 0.85;
                        break;
                    case "Sunday":
                        price = 10.46;
                        if (30 <= peopleNum)
                            price *= 0.85;
                        break;
                }
                break;

            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.9;
                        if (100 <= peopleNum)
                            peopleNum -= 10;
                        break;
                    case "Saturday":
                        price = 15.6;
                        if (100 <= peopleNum)
                            peopleNum -= 10;
                        break;
                    case "Sunday":
                        price = 16;
                        if (100 <= peopleNum)
                            peopleNum -= 10;
                        break;
                }
                break;

            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15;
                        if (10 <= peopleNum && peopleNum <= 20)
                            price *= 0.95;
                        break;
                    case "Saturday":
                        price = 20;
                        if (10 <= peopleNum && peopleNum <= 20)
                            price *= 0.95;
                        break;
                    case "Sunday":
                        price = 22.5;
                        if (10 <= peopleNum && peopleNum <= 20)
                            price *= 0.95;
                        break;
                }
        }
        System.out.printf("Total price: %.2f", price*peopleNum);
    }
}
