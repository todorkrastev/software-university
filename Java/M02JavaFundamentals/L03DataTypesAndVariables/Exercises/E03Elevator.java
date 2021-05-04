import java.util.Scanner;

public class E03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());
        int count = 0;

        while(numOfPeople > 0){
            numOfPeople -= capacity;
            count++;
        }
        System.out.println(count);
    }
}
