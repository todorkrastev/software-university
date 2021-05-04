import java.util.Arrays;
import java.util.Scanner;

public class E10LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] field = new int[fieldSize];

        int[] ladyBugsIndexes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray(); //индексите, на които има калинка

        for (int ladyBugIndex : ladyBugsIndexes) {
            if (ladyBugIndex >= 0 && ladyBugIndex <= field.length - 1) {
                field[ladyBugIndex] = 1;
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            //command = "0 right 1".split(" ") ->
            //0 от кой индекс се маха калинка
            //right -> посока на движение
            //1 с каква дължина се мести калинката
            String[] tokens = command.split(" "); //["0", "right", "1"]
            int index = Integer.parseInt(tokens[0]); //"0" -> 0
            String direction = tokens[1];
            int flyLength = Integer.parseInt(tokens[2]); //"1" -> 1

            //има летене ако: индексът е в масива и на индексът има калинка
            if (index >= 0 && index <= field.length - 1 && field[index] == 1) {
                //калинката излетява
                field[index] = 0;
                if (direction.equals("right")) {
                    index += flyLength; //нова позиция
                    //ПРОВЕРКА ДАЛИ КАЦА ИЛИ ОЩЕ ЩЕ ЛЕТИ
                    //дали новата позиция е свободна или е в полето
                    //спира да лети: излезе извън полето или няма калинка на новата и позиция
                    //продължава да лети:  ако е в полето и има калинка на новата и позиция
                    while (index <= field.length - 1 && field[index] == 1) { //ако излетим или намерим празно място
                        index += flyLength;
                    }
                    //СПИРАНЕ НА ЛЕТЕНЕ
                    //ако не е излетяла
                    if (index <= field.length - 1) {
                        field[index] = 1;
                        //каца
                    }
                } else if (direction.equals("left")) {
                    index -= flyLength;
                    //спира да лети: index < 0  или  на index няма калиннка
                    //продължава: index >= 0 && на индекса да има има калинка
                    while (index >= 0 && field[index] == 1) { //ако не намерим празно място или излетим
                        index -= flyLength;
                    }
                    if (index >= 0) {
                        field[index] = 1;
                    }
                }
            }


            command = scanner.nextLine();
        }

        for (int number : field) {
            System.out.print(number + " ");

        }
    }
}
