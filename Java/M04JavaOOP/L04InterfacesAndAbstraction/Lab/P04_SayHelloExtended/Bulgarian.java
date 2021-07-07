package bg.softuni.java_oop.interfaces_and_abstraction.lab.P04_SayHelloExtended;

public class Bulgarian extends BasePerson {
    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
