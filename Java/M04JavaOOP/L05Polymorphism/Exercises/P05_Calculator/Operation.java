package bg.softuni.java_oop.polymorphism.exercises.P05_Calculator;

public interface Operation {
    void addOperand(int operand);

    int getResult();

    boolean isCompleted();
}
