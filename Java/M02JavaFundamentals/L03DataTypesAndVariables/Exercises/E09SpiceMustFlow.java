import java.util.Scanner;

public class E09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int workersConsumeInAmount = 26;
        int workersConsume = 0;
        int count = 0;
        int sum = 0;

        while (0 < startingYield) {
            if (startingYield < 100) {
                if (workersConsume < 26) {
                    break;
                }
                sum -= workersConsumeInAmount;
                break;
            }

            workersConsume = startingYield - workersConsumeInAmount;
            startingYield -= 10;
            sum += workersConsume;
            count++;
        }
        System.out.println(count);
        System.out.println(sum);
    }
}


