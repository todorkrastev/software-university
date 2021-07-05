package bg.softuni.java_oop.encapsulation.exercises.P05_FootballTeamGenerator;

public class Validator {
    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
    }

    public static void validateStat(int statRating, String stat) {
        if (statRating < 0 || 100 < statRating) {
            throw new IllegalArgumentException(String.format("%s should be between 0 and 100.", stat));
        }
    }

    public Validator() {
    }
}
