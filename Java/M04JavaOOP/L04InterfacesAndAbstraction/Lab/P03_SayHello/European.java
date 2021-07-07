package bg.softuni.java_oop.interfaces_and_abstraction.lab.P03_SayHello;

public class European implements Person {
    private final String name;

    public European(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
