import java.util.Scanner;

public class E06ForegnLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLanguage = scanner.nextLine();

        switch (inputLanguage){
            case "England":
            case "USA":
                System.out.println("English");
                break;

            case "Spain":
            case "Argentina":
            case "Mexico":
                System.out.println("Spanish");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}
