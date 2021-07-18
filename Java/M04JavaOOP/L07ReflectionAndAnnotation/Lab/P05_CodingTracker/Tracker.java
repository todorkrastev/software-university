package bg.softuni.java_oop.reflection_and_annotation.lab.P05_CodingTracker;

public class Tracker {
    @Author(author = "Peter")
    public static void printMethodsByAuthor(Class<Tracker> clazz) {

        System.out.printf("%s: %s()%n",
                Main.class.getMethods()[0].getAnnotation(Author.class).author(),
                Main.class.getMethods()[0].getName());
        System.out.printf("%s: %s()%n",
                clazz.getMethods()[0].getAnnotation(Author.class).author(),
                clazz.getMethods()[0].getName());
    }
}