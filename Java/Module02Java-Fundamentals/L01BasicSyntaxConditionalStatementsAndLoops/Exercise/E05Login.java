import java.util.Scanner;

public class E05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";
        String insertPassword = "";
        int count = 0;

        for (int i = username.length() - 1; i >= 0; i--){
            password += username.charAt(i);
        }
        insertPassword = scanner.nextLine();
        while(!password.equals(insertPassword)){
            count++;
            if (count == 4){
                System.out.printf("User %s blocked!", username);
                return;
            }
            System.out.println("Incorrect password. Try again.");
            insertPassword = scanner.nextLine();
        }
        System.out.printf("User %s logged in.", username);
    }
}
