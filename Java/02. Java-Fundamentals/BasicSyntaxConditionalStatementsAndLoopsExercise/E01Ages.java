import java.util.Scanner;

public class E01Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputAge = Integer.parseInt(scanner.nextLine());

        if (0 <= inputAge && inputAge <= 2){
            System.out.println("baby");
        } else if (3 <= inputAge && inputAge <= 13){
            System.out.println("child");
        } else if (14 <= inputAge && inputAge <= 19){
            System.out.println("teenager");
        } else if (20 <= inputAge && inputAge <= 65){
            System.out.println("adult");
        } else if (66 <= inputAge){
            System.out.println("elder");
        }
    }
}
