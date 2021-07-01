package bg.softuni.java_oop.working_with_abstraction.exercises.P04_TrafficLights;

public enum StateMachine {
    RED,
    GREEN,
    YELLOW;

    public static StateMachine update(StateMachine state) {
        switch (state) {
            case RED:
                return GREEN;
            case GREEN:
                return YELLOW;
            case YELLOW:
                return RED;
        }
        return null;
    }
}

