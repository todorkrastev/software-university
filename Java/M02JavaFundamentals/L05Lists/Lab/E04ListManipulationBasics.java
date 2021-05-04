import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] array = input.split("\\s+");
            String token = array[0];
            String command = array[1];
            switch (token) {
                case "Add":
                    list.add(command);
                    break;
                case "Remove":
                    list.remove(String.valueOf(command));
                    break;
                case "RemoveAt":
                    list.remove(Integer.parseInt(command));
                    break;
                case "Insert":
                    String index = array[2];
                    list.add(Integer.parseInt(index), command);
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print(String.join(" ", list));
    }
}



