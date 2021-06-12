package GenericArrayCreatorSecondOption;

public class Main {
    public static void main(String[] args) {
        String[] javas = ArrayCreator.<String>create(String.class, 13, "Java");

        Integer[] integers = ArrayCreator.<Integer>create(Integer.class, 73, 69);
    }
}
