package bg.softuni.java_oop.interfaces_and_abstraction.lab.P03_SayHello;

public class Bulgarian implements Person {
    private final String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
