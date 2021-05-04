import java.util.Scanner;

public class E08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char input = scanner.nextLine().charAt(0);


        if (!(Character.isUpperCase(input))){
            System.out.println("lower-case");
        }
        else if (!(Character.isLowerCase(input))){
            System.out.println("upper-case");
        }
    }
}
