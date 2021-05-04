import java.util.Scanner;

public class E11MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());


        for (int i = times; i <= 10; i++){
            System.out.printf("%d X %d = %d%n", input, i, input*i);
        }
        if (10 < times){
            System.out.printf("%d X %d = %d%n", input, times, input*times);
        }
    }
}
