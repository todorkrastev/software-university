package bg.softuni.java_advanced.iterators_and_comparators.lab.P03_ComparableBook;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        if (bookOne.compareTo(bookTwo) > 0) {
            System.out.printf("%s is before %s%n", bookOne.getTitle(), bookTwo.getTitle());
        } else if (bookOne.compareTo(bookTwo) < 0) {
            System.out.printf("%s is before %s%n", bookTwo.getTitle(), bookOne.getTitle());
        } else {
            System.out.println("Books are equal");
        }

    }
}
