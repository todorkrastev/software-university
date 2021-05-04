import java.util.Scanner;

public class E07TheathrePromotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double priceOfTicket = 0.0;



        switch (inputDay){
            case "Weekday":
                if (0 <= age && age <= 18){
                    priceOfTicket = 12;
                } else if (18 < age && age <= 64){
                    priceOfTicket = 18;
                } else if (64 < age && age <= 122){
                    priceOfTicket = 12;
                } else{
                    System.out.println("Error!");
                    return;
                }
                break;

            case "Weekend":
                if (0 <= age && age <= 18){
                    priceOfTicket = 15;
                } else if (18 < age && age <= 64){
                    priceOfTicket = 20;
                } else if (64 < age && age <= 122){
                    priceOfTicket = 15;
                } else{
                    System.out.println("Error!");
                    return;
                }
                break;

            case "Holiday":
                if (0 <= age && age <= 18){
                    priceOfTicket = 5;
                } else if (18 < age && age <= 64){
                    priceOfTicket = 12;
                } else if (64 < age && age <= 122){
                    priceOfTicket = 10;
                } else{
                    System.out.println("Error!");
                    return;
                }
                break;
            }

            int value = (int)priceOfTicket;
        System.out.printf("%d$", value);
        }
    }

