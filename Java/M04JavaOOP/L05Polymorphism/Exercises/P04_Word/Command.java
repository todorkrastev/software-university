package bg.softuni.java_oop.polymorphism.exercises.P04_Word;

public class Command {
    private final String text;
    private final TextTransform textTransform;

    public Command(String text, TextTransform textTransform){
        this.text = text;
        this.textTransform = textTransform;
    }
    public String getText() {
        return this.text;
    }

    public TextTransform getTextTransform() {
        return this.textTransform;
    }
}
