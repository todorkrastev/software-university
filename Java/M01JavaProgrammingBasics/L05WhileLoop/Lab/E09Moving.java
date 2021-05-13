package bg.softuni.programming_basics.while_loop.lab;

import java.util.Scanner;

public class E09Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int leftCapacity = width * length * height;
        int numBox;

        while (true) {
            String n = scanner.nextLine();
            if (n.equals("Done")) {
                System.out.printf("%d Cubic meters left.", leftCapacity);
                break;
            } else {
                numBox = Integer.parseInt(n);
                if ((leftCapacity - numBox) < 0) {
                    System.out.printf("No more free space! You need %d Cubic meters more.", numBox - leftCapacity);
                    break;
                }
            }
            leftCapacity -= numBox;
        }
    }
}
