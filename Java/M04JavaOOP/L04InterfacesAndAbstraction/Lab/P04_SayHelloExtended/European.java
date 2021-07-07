package bg.softuni.java_oop.interfaces_and_abstraction.lab.P04_SayHelloExtended;

public class European extends BasePerson {
    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
