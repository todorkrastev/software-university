package P03_GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("a", "z");

        System.out.println(stringScale.getHeavier());

        Scale<Integer> integerScale = new Scale<>(69, 13);

        System.out.println(integerScale.getHeavier());

        Scale<Double> doubleScale = new Scale<>(2.5, 2.5);

        System.out.println(doubleScale.getHeavier());

    }
}
