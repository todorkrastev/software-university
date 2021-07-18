package bg.softuni.java_oop.reflection_and_annotation.lab.P05_CodingTracker;

public class Main {
    @Author(author = "George")
    public static void main(String[] args) {

        Tracker.printMethodsByAuthor(Tracker.class);

    }
}
