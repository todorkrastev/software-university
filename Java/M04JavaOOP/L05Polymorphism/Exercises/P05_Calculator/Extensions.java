package bg.softuni.java_oop.polymorphism.exercises.P05_Calculator;

public class Extensions {

    public static InputInterpreter buildInterpreter(CalculationEngine engine) {

        return new InputInterpreter(engine);
    }
}
