package bg.softuni.java_oop.polymorphism.exercises.P04_Word;

import java.util.*;

public class CommandImpl implements CommandInterface {
    static String cutPart;
    private final Map<String, TextTransform> commandTransforms;
    private final StringBuilder text;

    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.text = text;
    }

    protected List<Command> initCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command("uppercase", new ToUpperTransform()));
        commands.add(new Command("cut", new CutTransform()));
        commands.add(new Command("paste", new PasteTransform()));

        return commands;
    }

    @Override
    public void init() {
        this.commandTransforms.clear();
        for (Command p : this.initCommands()) {
            this.commandTransforms.putIfAbsent(p.getText(), p.getTextTransform());
        }
    }

    @Override
    public void handleInput(String input) {
        String[] tokens = input.split("\\s+");

        String commandName = tokens[0];
        int startInd = Integer.parseInt(tokens[1]);
        int endInd = Integer.parseInt(tokens[2]);
        List<Command> commands = initCommands();
        init();
        this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
    }

    static class ToUpperTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
        }
    }

    static class CutTransform implements TextTransform {

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            cutPart = text.substring(startIndex, endIndex);
            text.delete(startIndex, endIndex);
        }
    }

    static class PasteTransform implements TextTransform {

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            text.replace(startIndex, endIndex, cutPart);
        }
    }
}
