package bg.softuni.java_oop.interfaces_and_abstraction.lab.P04_SayHelloExtended;

public class Chinese extends BasePerson {
    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
