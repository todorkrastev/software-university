import javax.swing.plaf.basic.BasicButtonUI;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class E02PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal input = new BigDecimal(scanner.nextLine());
        double USDollars = 1.31;
        BigDecimal BritishPoundToUSDollar = input.multiply(BigDecimal.valueOf(USDollars));

        System.out.printf("%.3f", BritishPoundToUSDollar);
    }
}
