package bg.softuni.java_oop.polymorphism.exercises.P04_Word;

public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text) {
        return new CommandImpl(text);
    }
}

