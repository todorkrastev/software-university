package bg.softuni.java_oop.interfaces_and_abstraction.lab.P03_SayHello;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    }
}
