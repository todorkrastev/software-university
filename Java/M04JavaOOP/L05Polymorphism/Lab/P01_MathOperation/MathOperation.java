package bg.softuni.java_oop.polymorphism.lab.P01_MathOperation;

public class MathOperation {
    public MathOperation() {
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return this.add(a, b) + c;
    }

    public int add(int a, int b, int c, int d) {
        return this.add(a, b, c) + d;
    }
}
